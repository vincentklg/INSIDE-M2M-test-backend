package org.acme.controller;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.ConnectionType;
import org.acme.exception.DeviceNotFoundException;
import org.acme.exceptionhandler.ExceptionHandler;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.acme.entity.M2MDevice;
import org.acme.service.M2MDeviceService;

import java.util.Date;

@RequestScoped
@Path("/v1/device")
public class M2MDeviceController {

    private final M2MDeviceService deviceService;

    @Inject
    public M2MDeviceController(M2MDeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GET
    @Operation(summary = "Fetches a device by Id", description = "Response with the corresponding device as a JSON-Object")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = M2MDevice.class))),
            @APIResponse(responseCode = "404", description="User not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionHandler.ErrorResponseBody.class)))
    })
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/read/{id}")
    public M2MDevice getDevice(@PathParam("id") long id)throws DeviceNotFoundException {
        return deviceService.getDeviceById(id);
    }

    @POST
    @Operation(summary = "Creates a new device", description = "Response with the successfully created device as a JSON-Object")
    @APIResponses(value = @APIResponse(responseCode = "201", description = "Created",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = M2MDevice.class))))
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public M2MDevice createDevice(DeviceDto deviceDto) {
        return deviceService.saveDevice(deviceDto.toDevice());
    }

    @Schema(name="DeviceDTO", description="Device representation to create")
    public static class DeviceDto {

        @Schema(title = "External Id", required = true)
        private String externalID;

        @Schema(title = "Created")
        private Date created;

        @Schema(title = "Connection Type", required = true)
        private ConnectionType connectionType;


        /*public long getId() {
            return id;
        }

        public void setId(long newId) {
            this.id = newId;
        }*/

        public String getExtId() {
            return externalID;
        }

        public void setExtId(String newExtId) {
            this.externalID = newExtId;
        }

        public Date getCreated() {
            return created;
        }

        public void setCreated(Date newCreatedDate) {
            this.created = newCreatedDate;
        }

        public ConnectionType getConnectionTyp() {
            return connectionType;
        }

        public void setConnectionType(ConnectionType newConnTyp) {
            this.connectionType = newConnTyp;
        }


        public M2MDevice toDevice() {
            M2MDevice device = new M2MDevice();
            device.setExternalId(externalID);
            device.setCreated(created);
            device.setConnectionType(connectionType);
            return device;
        }
    }
}
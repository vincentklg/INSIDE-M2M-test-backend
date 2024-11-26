package org.acme.config;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
        tags = {
                @Tag(name = "Device", description = "Device operations."),
        },
        info = @Info(
                title = "M2MDevice API with Quarkus",
                version = "0.0.1",
                contact = @Contact(
                        name = "Vincent Klingemann",
                        email = "vincent@klingemann.me"),
                license = @License(
                        name = "GPL",
                        url = "https://opensource.org/licenses/GPL"))
)
public class SwaggerConfig extends Application {

}

CREATE TABLE IF NOT EXISTS devices (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    external_id VARCHAR(256) NOT NULL,
    created DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    connection_type ENUM('CELLULAR', 'WLAN', 'LAN', 'UNKNOWN') NOT NULL
) engine=InnoDB;
create table device_info(
                            id int primary key auto_increment,
                            name varchar(32) not null,
                            code varchar(64) not null,
                            manufacture_date datetime not null,
                            manufacture_number varchar(64) not null,
                            manufacturer varchar(64) not null,
                            device_status varchar(16) not null
);


INSERT INTO device_info (name, code, manufacture_date, manufacture_number, manufacturer, device_status)
VALUES
('Thermometer X200', 'THX200-001', '2023-05-15 14:30:00', 'SN1234567890', 'HealthTech Corp', 'Active'),
('Pressure Sensor P450', 'PSP450-002', '2021-11-22 09:15:00', 'SN0987654321', 'Sensors Inc.', 'Inactive'),
('Heart Rate Monitor H300', 'HRM300-003', '2022-07-30 10:45:00', 'SN5678901234', 'MediEquip Ltd', 'Active'),
('Air Quality Analyzer AQ500', 'AQA500-004', '2023-01-10 08:00:00', 'SN3456789012', 'EnviroTech Co.', 'Maintenance'),
('Industrial Robot IR800', 'IR800-005', '2020-03-18 13:25:00', 'SN2345678901', 'RoboMatic Industries', 'Active'),
('Water Purifier WP100', 'WP100-006', '2022-10-05 15:20:00', 'SN4567890123', 'PureLife Systems', 'Inactive'),
('Solar Panel SP600', 'SP600-007', '2021-06-12 12:30:00', 'SN6789012345', 'SolarPro Manufacturing', 'Active'),
('Electric Vehicle Charger EV300', 'EVC300-008', '2023-09-25 16:40:00', 'SN7890123456', 'ChargeTech Solutions', 'Active'),
('Medical Scanner MS400', 'MS400-009', '2022-04-19 11:50:00', 'SN8901234567', 'ScanWell Medical', 'Maintenance'),
('Smart Watch SW700', 'SW700-010', '2023-08-15 14:00:00', 'SN9012345678', 'WearableTech Inc.', 'Active');



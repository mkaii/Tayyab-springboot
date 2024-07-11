INSERT INTO rooms (floor, price, roomdescription, roomnumber, roomtype) VALUES (1, 150, 'Accessible Comfort', '101', 'SINGLE');
INSERT INTO rooms (floor, price, roomdescription, roomNumber, roomtype) VALUES (2, 120, 'Classic Comfort', '102', 'DOUBLE');

INSERT INTO guests (guestContactNumber, guestEmail, guestFirstName, guestGender, guestLastName) VALUES ('0465755747', 'tayyab32@hotmail.com', 'Tayyab', 'MALE', 'Mehmood');
INSERT INTO guests (guestContactNumber, guestEmail, guestFirstName, guestGender, guestLastName) VALUES ('0470123456', 'lucas.peeters@email.be', 'Lucas', 'MALE', 'Peeters');

INSERT INTO reservations (guest_id, room_id, totalGuest, check_in_date, check_out_date) VALUES (1, 1, 3, '2023-12-31 00:00:00.000000', '2024-01-17 00:00:00.000000');
INSERT INTO reservations (guest_id, room_id, totalGuest, check_in_date, check_out_date) VALUES (2, 1, 1, '2024-03-20 00:00:00.000000', '2024-03-25 00:00:00.000000');
INSERT INTO reservations (guest_id, room_id, totalGuest, check_in_date, check_out_date) VALUES (2, 2, 1, '2024-03-20 00:00:00.000000', '2024-03-25 00:00:00.000000');

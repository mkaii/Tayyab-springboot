INSERT INTO hoteldb.rooms (floor, price,  roomdescription, roomnumber, roomtype) VALUES ( 1,150,  'Accessible Comfort', '101', 'SINGLE');
INSERT INTO hoteldb.rooms (floor, price,  roomdescription, roomnumber, roomtype) VALUES (2,120,  'Classic Comfort', '102', 'DOUBLE');
INSERT INTO hoteldb.rooms (floor, price,  roomdescription, roomnumber, roomtype) VALUES (3, 300,  'Deluxe Suite', '103', 'DELUXE');
INSERT INTO hoteldb.rooms (floor, price,  roomdescription, roomnumber, roomtype) VALUES (4, 180,  'Eco Friendly Green Room', '401', 'DOUBLE');
INSERT INTO hoteldb.rooms (floor, price,  roomdescription, roomnumber, roomtype) VALUES (  5,200, 'Executive Business', '201', 'STUDIO');
INSERT INTO hoteldb.rooms (floor, price,  roomdescription, roomnumber, roomtype) VALUES ( 6,250,  'Family Fun Suite', '301', 'STUDIO');
INSERT INTO hoteldb.rooms (floor, price,  roomdescription, roomnumber, roomtype) VALUES ( 7, 250, 'Romantic Getaway', '302', 'DELUXE');


INSERT INTO hoteldb.guests ( guestage, guestcontactnumber, guestemail, guestfirstname, guestgender, guestlastname) VALUES ( 25, '0465755747', 'tayyab32@hotmail.com', 'Tayyab', 'MALE', 'Mehmood');
INSERT INTO hoteldb.guests (guestage, guestcontactnumber, guestemail, guestfirstname, guestgender, guestlastname) VALUES ( 25, '0470123456', 'lucas.peeters@email.be', 'Lucas', 'MALE', 'Peeters');
INSERT INTO hoteldb.guests ( guestage, guestcontactnumber, guestemail, guestfirstname, guestgender, guestlastname) VALUES ( 30, '0471654321', 'emma.janssens@email.be', 'Emma', 'FEMALE', 'Janssens');
INSERT INTO hoteldb.guests ( guestage, guestcontactnumber, guestemail, guestfirstname, guestgender, guestlastname) VALUES ( 35, '0472233445', 'noah.maes@email.be', 'Noah', 'MALE', 'Maes');
INSERT INTO hoteldb.guests ( guestage, guestcontactnumber, guestemail, guestfirstname, guestgender, guestlastname) VALUES ( 28, '0473777888', 'louise.jacobs@email.be', 'Louise', 'FEMALE', 'Jacobs');
INSERT INTO hoteldb.guests ( guestage, guestcontactnumber, guestemail, guestfirstname, guestgender, guestlastname) VALUES ( 32, '0474123456', 'arthur.willems@email.be', 'Arthur', 'MALE', 'Willems');
INSERT INTO hoteldb.guests (guestage, guestcontactnumber, guestemail, guestfirstname, guestgender, guestlastname) VALUES ( 29, '0475987654', 'marie.dupont@email.be', 'Marie', 'FEMALE', 'Dupont');
INSERT INTO hoteldb.guests ( guestage, guestcontactnumber, guestemail, guestfirstname, guestgender, guestlastname) VALUES ( 33, '0476444555', 'liam.lambert@email.be', 'Liam', 'MALE', 'Lambert');
INSERT INTO hoteldb.guests ( guestage, guestcontactnumber, guestemail, guestfirstname, guestgender, guestlastname) VALUES ( 27, '0476777888', 'alice.claes@email.be', 'Alice', 'FEMALE', 'Claes');

INSERT INTO hoteldb.reservations (guest_id,  room_id, totalguest, check_in_date, checkout_out_date) VALUES (6,  5, 3, '2023-12-31 00:00:00.000000', '2024-01-17 00:00:00.000000');
INSERT INTO hoteldb.reservations (guest_id,  room_id, totalguest, check_in_date, checkout_out_date) VALUES (1, 3, 1, '2024-03-20 00:00:00.000000', '2024-03-25 00:00:00.000000');
INSERT INTO hoteldb.reservations (guest_id,  room_id, totalguest, check_in_date, checkout_out_date) VALUES (7,  6, 2, '2024-04-28 00:00:00.000000', '2024-05-01 00:00:00.000000');
INSERT INTO hoteldb.reservations (guest_id,  room_id, totalguest, check_in_date, checkout_out_date) VALUES (8,  4, 1, '2024-05-02 00:00:00.000000', '2024-05-04 00:00:00.000000');
INSERT INTO hoteldb.reservations (guest_id,  room_id, totalguest, check_in_date, checkout_out_date) VALUES (2,  3, 2, '2024-05-20 00:00:00.000000', '2024-05-22 00:00:00.000000');
INSERT INTO hoteldb.reservations (guest_id,  room_id, totalguest, check_in_date, checkout_out_date) VALUES (1,  1, 1, '2024-06-28 00:00:00.000000', '2024-07-10 00:00:00.000000');
INSERT INTO hoteldb.reservations (guest_id,  room_id, totalguest, check_in_date, checkout_out_date) VALUES (9,  2, 2, '2024-08-29 00:00:00.000000', '2024-09-04 00:00:00.000000');
INSERT INTO hoteldb.reservations (guest_id,  room_id, totalguest, check_in_date, checkout_out_date) VALUES (3,  7, 1, '2024-09-10 00:00:00.000000', '2024-09-20 00:00:00.000000');
INSERT INTO hoteldb.reservations (guest_id,  room_id, totalguest, check_in_date, checkout_out_date) VALUES (4,  1, 2, '2024-09-22 00:00:00.000000', '2024-10-03 00:00:00.000000');
INSERT INTO hoteldb.reservations (guest_id,  room_id, totalguest, check_in_date, checkout_out_date) VALUES (5,  4, 2, '2024-11-21 00:00:00.000000', '2024-12-05 00:00:00.000000');

INSERT INTO hoteldb.rooms_guests (guest_id, room_id) VALUES (1, 1);
INSERT INTO hoteldb.rooms_guests (guest_id, room_id) VALUES (2, 2);
INSERT INTO hoteldb.rooms_guests (guest_id, room_id) VALUES (5, 7);
INSERT INTO hoteldb.rooms_guests (guest_id, room_id) VALUES (4, 3);
INSERT INTO hoteldb.rooms_guests (guest_id, room_id) VALUES (5, 4);
INSERT INTO hoteldb.rooms_guests (guest_id, room_id) VALUES (6, 5);
INSERT INTO hoteldb.rooms_guests (guest_id, room_id) VALUES (7, 6);
INSERT INTO hoteldb.rooms_guests (guest_id, room_id) VALUES (8, 7);
INSERT INTO hoteldb.rooms_guests (guest_id, room_id) VALUES (9, 5);
INSERT INTO hoteldb.rooms_guests (guest_id, room_id) VALUES (7, 6);
INSERT INTO hoteldb.rooms_guests (guest_id, room_id) VALUES (3, 1);
INSERT INTO hoteldb.rooms_guests (guest_id, room_id) VALUES (4, 3);
INSERT INTO hoteldb.rooms_guests (guest_id, room_id) VALUES (2, 6);

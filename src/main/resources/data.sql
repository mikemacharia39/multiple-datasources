INSERT INTO customer (customerID, firstName, lastName, emailAddress, status, dateCreated, dateModified)
VALUES (NULL, "Mikehenry", "Maina", "mike@gmail.com", "ACTIVE", CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(NULL, "Harrison", "Macharia", "harris@gamil.com", "ACTIVE", CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO customer (customerID, firstName, lastName, emailAddress, status, dateCreated, dateModified)
VALUES (NULL, "Mike", "Drake", "mikedrake@gmail.com", "ACTIVE", CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(NULL, "Michael", "Macharia", "michael@gamil.com", "ACTIVE", CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO product (productID, productName, description, price, active, dateCreated, dateModified)
VALUES (NULL, "Bike", "Cycle", 23000.00, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(NULL, "Office Desk", "A desk", 12000.00, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO payment (paymentID, customerID, productID, quantity, unitPrice, totalPrice, active, dateCreated, dateModified)
VALUES (NULL, 1, 1, 1, 23000.00, 23000, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO payment (paymentID, customerID, productID, quantity, unitPrice, totalPrice, active, dateCreated, dateModified)
VALUES (NULL, 1, 2, 3, 12000.00, 36000, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
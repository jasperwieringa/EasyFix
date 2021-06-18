INSERT INTO APPOINTMENT ( COMPUTER, DESCRIPTION, ISSUES, STATUS ) VALUES
    ( 'DELL', 'Descr 1', 'Cable broken', 'In progress' ),
    ( 'DELL', 'Descr 2', 'Cable broken', 'Something' ),
    ( 'DELL', 'Descr 3', 'Cable broken', 'Anothers' ),
    ( 'DELL', 'Descr 4', 'Cable broken', 'Pewpew' ),
    ( 'DELL', 'Descr 5', 'Cable broken', 'Duh' );

INSERT INTO CUSTOMER ( FIRST_NAME, LAST_NAME, ADDRESS, POSTAL_CODE, TOWN, EMAIL, PHONE, APPOINTMENT_ID ) VALUES
    ('Joyce', 'Rocker', 'Markt 10', '9701CZ', 'Wageningen', 'isvemplwmrf@gmail.com', '06-20373233', 1 ),
    ( 'Lucca', 'Profijt', 'Kerkweg 121', '9602VD', 'Hoogezand', 'l.profijt@gmail.com', '06-57127869', 2 ),
    ( 'Saman', 'van Orth', 'Eilandenweg 61', '2904VJ', 'Capelle aan den IJssel', 's.v.orth@gmail.com', '06-50248603', NULL ),
    ( 'Rayen', 'Toetenel', 'Majolicastraat 20', '9216AH', 'Maastricht', 'r.toetenel@gmail.com', '06-72682758', NULL ),
    ( 'Caine', 'Joekel', 'Bachrode 138', '2717AL', 'Zoetermeer', 'c.joekel@gmail.com', '06-81496468', 3 ),
    ( 'Sona', 'Massar', 'Hoflaan 65', '5044HA', 'Tilburg', 's.massar@gmail.com', '06-29498248', 4 ),
    ( 'Jaap', 'Onstenk', 'Molendreef 68', '4641CV', 'Ossendrecht', 'j.onstenk@gmail.com', '06-37017609', NULL ),
    ( 'Jelco', 'van Kleef', 'Wendelnesseweg Oost 100', '5161ZA', 'Sprang-Capelle', 'j.v.kleef@gmail.com', '06-45818403', NULL ),
    ( 'Leroy', 'Koppert', 'Koninginnelaan 171', '6542ZT', 'Nijmegen', 'l.koppert@gmail.com', '06-91568118', 5 ),
    ( 'Janiek', 'Bruggeman', 'Noordsingel 63', '4333AC', 'Middelburg', 'j.bruggeman@gmail.com', '06-84790835', NULL );

INSERT INTO APP_USER ( APP_USER_DEPARTMENT, EMAIL, ENABLED, FIRST_NAME, LAST_NAME, LOCKED, PASSWORD ) VALUES
    ( 'ADMIN', 'admin@easyfix.nl', TRUE, 'Kees', 'Holman', FALSE, '$2y$12$zgwFyki4zI0WNZl9r9BZZeKIF7DbKoDLI46xJEg6zinwSiyHoyfLy' ),
    ( 'EXPERT', 'expert@easyfix.nl', TRUE, 'Anton', 'Schaaf', FALSE, '$2y$12$NkhRLoAICSoERzShsyGy2ejqthgtX9U/Z90DNMgtE4yTb53pNIFCK' ),
    ( 'CASHIER', 'cashier@easyfix.nl', TRUE, 'Pieter', 'Klomp', FALSE, '$2y$12$PdhN2I2gfq3f0DcDMOpdbea9xhDcSrRjc0VHXrYBT934dlrZjRcnK' ),
    ( 'BACKOFFICE', 'backoffice@easyfix.nl', TRUE, 'Jantje', 'Schuursen', FALSE, '$2y$12$ZDzrjEcEP9Vy4RjboI6ZzuiulVbhcPR8tH/Yvy0VIrbETx.uBOhFa');
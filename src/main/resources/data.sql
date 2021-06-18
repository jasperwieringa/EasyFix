INSERT INTO APPOINTMENT ( COMPUTER, DESCRIPTION, STATUS, DATE, ISSUES, ACTIVITIES, RECEIPT_ID ) VALUES
    ( 'Alienware Aurora', 'Customer says that he can no longer startup his computer', 'In progress', '2021-05-24', 'The SD cable was broken and the Harddrive seems to be defect', 'Replaced the SD cable and replaced the Harddrive', NULL ),
    ( 'MacBook Air', 'Descr 2', 'Finished', '2021-06-18', 'No issues found',  'No activities executed', NULL ),
    ( 'Dell Vostro 5880', 'Descr 2', 'Finished', '2021-06-18', 'No issues found',  'No activities executed', NULL ),
    ( 'Dell XPS 13', 'Descr 2', 'Finished', '2021-06-18', 'No issues found',  'No activities executed', NULL );

INSERT INTO CUSTOMER ( FIRST_NAME, LAST_NAME, ADDRESS, POSTAL_CODE, TOWN, EMAIL, PHONE, APPOINTMENT_ID ) VALUES
    ( 'Joyce', 'Rocker', 'Markt 10', '9701CZ', 'Wageningen', 'isvemplwmrf@gmail.com', '06-20373233', 1 ),
    ( 'Lucca', 'Profijt', 'Kerkweg 121', '9602VD', 'Hoogezand', 'l.profijt@gmail.com', '06-57127869', 2 ),
    ( 'Saman', 'van Orth', 'Eilandenweg 61', '2904VJ', 'Capelle aan den IJssel', 's.v.orth@gmail.com', '06-50248603', 3 ),
    ( 'Rayen', 'Toetenel', 'Majolicastraat 20', '9216AH', 'Maastricht', 'r.toetenel@gmail.com', '06-72682758', NULL );

INSERT INTO APP_USER ( APP_USER_DEPARTMENT, EMAIL, ENABLED, FIRST_NAME, LAST_NAME, LOCKED, PASSWORD ) VALUES
    ( 'ADMIN', 'admin@easyfix.nl', TRUE, 'Kees', 'Holman', FALSE, '$2y$12$zgwFyki4zI0WNZl9r9BZZeKIF7DbKoDLI46xJEg6zinwSiyHoyfLy' ),
    ( 'EXPERT', 'expert@easyfix.nl', TRUE, 'Anton', 'Schaaf', FALSE, '$2y$12$NkhRLoAICSoERzShsyGy2ejqthgtX9U/Z90DNMgtE4yTb53pNIFCK' ),
    ( 'CASHIER', 'cashier@easyfix.nl', TRUE, 'Pieter', 'Klomp', FALSE, '$2y$12$PdhN2I2gfq3f0DcDMOpdbea9xhDcSrRjc0VHXrYBT934dlrZjRcnK' ),
    ( 'BACKOFFICE', 'backoffice@easyfix.nl', TRUE, 'Jantje', 'Schuursen', FALSE, '$2y$12$ZDzrjEcEP9Vy4RjboI6ZzuiulVbhcPR8tH/Yvy0VIrbETx.uBOhFa');
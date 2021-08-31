INSERT INTO public.address
    (id, city, postal_code, street, street_number)
VALUES
    (1001, 'Lübeck', '23569', 'Im Schlag', '1a'),
    (1002, 'Leipzig', '04279', 'Müllerstraße', '196'),
    (1003, 'Bremen', '28211', 'Eschlohn', '81'),
    (1004, 'Saarbrücken', '66129', 'Jakob-Kneipe-Straße', '35');

INSERT INTO public.branch
    (id, address_id)
VALUES
    (1001, 1001),
    (1002, 1002),
    (1003, 1003),
    (1004, 1004);

INSERT INTO public.car
    (id, brand, model, production_year, specification, branch_id, base_price_per_day)
VALUES
    (1001, 'Ford', 'Mondeo', '2017', 'Liftback 2.0 EcoBoost 240KM 177kW', 1001, 60.00),
    (1002, 'Ford', 'Mondeo', '2017', 'Liftback 2.0 EcoBoost 240KM 177kW', 1001, 55.00),
    (1003, 'Ford', 'Explorer', '2018', '2.3 EcoBoost 240KM 177kW', 1001, 120.00),
    (1004, 'Audi', 'A3', '2017', '8V Hatchback 3d 2.0 TDI 15KM 110kW', 1001, 60.00),
    (1005, 'Audi', 'A5', '2019', 'RS5 Sportback 2.9 TFSI 450KM 331kW', 1001, 120.00);

INSERT INTO public.employee
    (id, first_name, last_name, user_name, password, "position", is_admin , branch_id)
VALUES
    (1001, 'Levin', 'Janson', 'admin', 'admin', 'administrator', TRUE, 1001),
    (1002, 'Rosetraut', 'Schlotterbeck', 'e', 'e', 'director', FALSE, 1001),
    (1003, 'Bernadette', 'Ostendorf', 'b-ostendorf', 'ostendorf', 'accountant', FALSE, 1001),
    (1004, 'Marie', 'Inge', 'ingemarie', 'ingemarie62', 'salesman', FALSE, 1001),
    (1005, 'Senta', 'Speckmann', 's-speckmann', 'sspeckmann', 'salesman', FALSE, 1001),
    (1006, 'Dieterich', 'Merkert', 'dmerkert', 'd_merkert', 'manager', FALSE, 1002),
    (1007, 'Jochen', 'Hau', 'jochenhau', 'jochen_hau', 'salesman', FALSE, 1002),
    (1008, 'Werngard', 'Böhne', 'werngardboehne', 'w_boehne', 'salesman', FALSE, 1002),
    (1009, 'Hertha', 'Bossert', 'hbossert', 'h_bossert', 'salesman', FALSE, 1003),
    (10010, 'Hellmut', 'Gray', 'hgray', 'h_grey', 'salesman', FALSE, 1003),
    (10011, 'Raik', 'Görg', 'r_goerg', 'rgoerg', 'salesman', FALSE, 1004),
    (10012, 'Hildebrand', 'Swoboda', 'h-swoboda', 'hswoboda', 'salesman', FALSE, 1004);

INSERT INTO public.customer
    (id, email, first_name, last_name, password, user_name, address_id)
VALUES
    (1001, 'arnoldgrigoleit@private.none', 'Arnold', 'Grigoleit', 'arigrigo', 'arniegrig', 1001),
    (1002, 'treuhard-axt@comp.none', 'Treuhard', 'Axt', 'treuaxt', 'treuhardaxt', 1002);

INSERT INTO public.reservation
    (id, cost, reservation_start, reservation_end, reservation_date, car_id, customer_id)
VALUES
    (1001, 500, DATE'2021-10-10', DATE'2021-10-14', DATE'2021-08-22', 1001, 1001),
    (1002, 400, DATE'2021-10-09', DATE'2021-10-13', DATE'2021-08-10', 1002, 1002),
    (1003, 300, DATE'2021-11-10', DATE'2021-11-18', DATE'2021-07-05', 1001, 1002),
    (1004, 1200, DATE'2021-12-12', DATE'2021-12-21', DATE'2021-06-12', 1003, 1001);

INSERT INTO public.damage
    (id, damage_penalty, description)
VALUES
    (1001, 0, '-'),
    (1002, 50, 'broken mirror'),
    (1003, 100, 'accident, broken doors'),
    (1004, 0, '-');

INSERT INTO public.rental
    (id, overdue_penalty, return_date, was_overdue, damage_id, reservation_id)
VALUES
    (1001, 0, DATE'2021-10-14', FALSE, 1001, 1001),
    (1002, 100, DATE'2021-10-09', TRUE, 1002, 1002);

INSERT INTO public.invoice
    (id, issue_date, rental_id)
VALUES
    (1001, DATE'2021-10-14', 1001),
    (1002, DATE'2021-10-09', 1002);
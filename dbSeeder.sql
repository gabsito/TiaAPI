use tia;

-- Poblar la tabla Local
INSERT INTO local (id_local, codigo_local, direccion) VALUES
(1, 'LOC001', 'Av. Principal 123'),
(2, 'LOC002', 'Calle Secundaria 456'),
(3, 'LOC003', 'Av. Industrial 789'),
(4, 'LOC004', 'Calle Comercial 321'),
(5, 'LOC005', 'Plaza Central 654'),
(6, 'LOC006', 'Boulevard 987'),
(7, 'LOC007', 'Zona Norte 159'),
(8, 'LOC008', 'Zona Sur 753'),
(9, 'LOC009', 'Avenida Libertad 852'),
(10, 'LOC010', 'Calle Colon 951');

-- Poblar la tabla Producto
INSERT INTO producto (id_producto, codigo_producto, descripcion, precio) VALUES
(1, 'PROD001', 'Producto A', 10.50),
(2, 'PROD002', 'Producto B', 15.75),
(3, 'PROD003', 'Producto C', 7.80),
(4, 'PROD004', 'Producto D', 12.60),
(5, 'PROD005', 'Producto E', 20.30),
(6, 'PROD006', 'Producto F', 5.40),
(7, 'PROD007', 'Producto G', 18.90),
(8, 'PROD008', 'Producto H', 22.10),
(9, 'PROD009', 'Producto I', 9.99),
(10, 'PROD010', 'Producto J', 14.50);

-- Poblar la tabla Stock
INSERT INTO stock (id_stock, id_producto, id_local, cantidad) VALUES
(1, 1, 1, 100),
(2, 2, 2, 50),
(3, 3, 3, 75),
(4, 4, 4, 120),
(5, 5, 5, 60),
(6, 6, 6, 80),
(7, 7, 7, 90),
(8, 8, 8, 40),
(9, 9, 9, 110),
(10, 10, 10, 55);

-- Poblar la tabla Venta
INSERT INTO venta (id_venta, id_local, id_producto, cantidad, fecha_venta) VALUES
(1, 1, 1, 2, '2024-02-01 10:30:00'),
(2, 2, 2, 1, '2024-02-02 14:45:00'),
(3, 3, 3, 3, '2024-02-03 09:15:00'),
(4, 4, 4, 2, '2024-02-04 16:20:00'),
(5, 5, 5, 5, '2024-02-05 11:10:00'),
(6, 6, 6, 1, '2024-02-06 13:55:00'),
(7, 7, 7, 4, '2024-02-07 17:40:00'),
(8, 8, 8, 2, '2024-02-08 08:25:00'),
(9, 9, 9, 3, '2024-02-09 19:30:00'),
(10, 10, 10, 1, '2024-02-10 12:00:00');

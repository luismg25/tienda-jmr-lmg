
INSERT INTO categorias (nombre, descripcion, imagen) VALUES
    ('Gemas Preciosas',     'Piedras de alta pureza y valor gemológico.',         'gemas.jpg'),
    ('Piedras Ornamentales','Piedras estéticas de gama media para decoración.',   'ornamentales.jpg'),
    ('Piedras Comunes',     'Rocas y piedras abundantes de uso general.',         'comunes.jpg'),
    ('Minerales',           'Especímenes cristalinos y menas metálicas.',         'minerales.jpg'),
    ('Fósiles',             'Restos orgánicos mineralizados de eras geológicas.', 'fosiles.jpg'),
    ('Próximamente...',     '¡Novedades dentro de poco!',                         NULL);

INSERT INTO productos (nombre, id_categoria, precio, agotado, origen, fecha_ingreso,
                       peso, ancho, alto, largo, descripcion, imagen) VALUES
    ('Diamante Azul', 1, 12000.00, false, NULL,        '2024-01-10', NULL, 1.1, 1.1, 0.9, 'Rareza extrema.',     'https://www.naturaldiamonds.com/wp-content/uploads/2025/03/HIS_AUC_Francois-Curiel-profile_7634-lot-212-The-Wittelsbach-Blue_IMG_4x5.jpg'),
    ('Rubí Sangre',   1,  4500.00, false, NULL,        '2024-02-05', 1.2,  0.8, 0.8, 0.6, 'Color rojo intenso.', 'https://imgcdn1.gempundit.com/media/catalog/product/g/p1/gp55623-1-130521.jpg'),
    ('Esmeralda',     1,  3800.00, true,  'Colombia',  '2024-02-15', 2.1,  1.5, 1.4, 1.0, NULL,                  'https://jrcolombianemeralds.com/cdn/shop/files/jr-colombian-emeralds-default-title-3-86-carat-deep-emerald-green-natural-loose-colombian-emerald-oval-cut-23042052980830.jpg'),
    ('Zafiro Real',   1,  5100.00, false, 'Sri Lanka', '2024-03-01', 1.7,  1.0, 1.0, 0.9, 'Azul real.',          'https://www.claudiahamann.com/hmn/uploads/2019/06/ClaudiaHamann_Sapphire_Ceylon_Octagon_RoyalBlue_452cts_.jpg'),
    ('Alejandrita',   1,  7200.00, false, NULL,        '2024-03-20', NULL, 0.6, 0.6, 0.5, NULL,                  'https://omiprive.com/wp-content/uploads/2023/08/Alexandrite_new.jpg'),
    ('Espinela Roja', 1,  1800.00, false, 'Tanzania',  '2024-04-01', 3.0,  1.2, 1.2, 1.0, NULL,                  'https://marcelvermeulen.com/cdn/shop/articles/spinel_blog.jpg');

INSERT INTO productos (nombre, id_categoria, precio, agotado, origen, fecha_ingreso,
                       peso, ancho, alto, largo, descripcion, imagen) VALUES
    ('Lapislázuli Extra', 2, 150.00, false, 'Afganistán', '2024-01-15', NULL,   10.0, 8.0, 5.0, 'Azul intenso.',   'https://www.templodebuda.com/wp-content/uploads/2019/11/Lapis-Lazuli-Pequeno-Extra-scaled.jpg'),
    ('Malaquita Pulida',  2,  85.00, false, NULL,         '2024-02-10', NULL,    7.0, 6.0, 4.0, 'Bandas verdes.',  'https://m.media-amazon.com/images/I/61nI0P-+cdL._AC_UF894,1000_QL80_.jpg'),
    ('Rodocrosita',       2, 120.00, false, 'Argentina',  '2024-02-28', 200.0,  5.0, 5.0, 4.0, NULL,              'https://museomine.unizar.es/wp-content/uploads/2022/04/Rodocrosita-ER96H1f.jpg'),
    ('Jade Nefrita',      2, 210.00, false, NULL,         '2024-03-15', 450.0, 12.0, 6.0, 2.0, 'Símbolo de buena suerte.', 'https://mineraly.es/media/cache/square_600/product/2024/01/12561/jade-nephrite-145.jpg'),
    ('Turquesa Natural',  2,  95.00, true,  NULL,         '2024-04-05', NULL,    4.0, 3.0, 2.0, 'Azul cielo.',     'https://upload.wikimedia.org/wikipedia/commons/b/b8/Turquoise.pebble.700pix.jpg'),
    ('Amatista Geoda',    2, 180.00, false, 'Uruguay',    '2024-04-12', 1200.0,15.0,12.0,10.0, 'Cristal violeta.','https://sylviacrystals.com/cdn/shop/files/Amethyst-geode-Sylvia-Crystals-Sp.-z-o.o.-44643937.png');

INSERT INTO productos (nombre, id_categoria, precio, agotado, origen, fecha_ingreso,
                       peso, ancho, alto, largo, descripcion, imagen) VALUES
    ('Obsidiana Negra', 3, 25.00, false, 'México',  '2024-01-20', NULL,  10.0,10.0, 8.0, 'Vidrio volcánico.',        'https://m.media-amazon.com/images/I/61AwATe82hS._AC_UF894,1000_QL80_.jpg'),
    ('Cuarzo Rosa',     3, 15.00, false, 'Brasil',  '2024-02-12', 600.0,12.0, 8.0, 8.0, NULL,                       'https://cdn.shopify.com/s/files/1/0266/2688/3633/files/Metaphysical_and_Healing_Properties_Lore_480x480.jpg'),
    ('Ágata Cornalina', 3, 12.00, false, NULL,      '2024-03-05', NULL,   5.0, 4.0, 3.0, NULL,                       'https://vivescortadaimport.com/diccionario-minerales/minerales/cornalina/cornalina.jpg'),
    ('Sodalita',        3, 20.00, false, NULL,      '2024-03-18', 300.0,  8.0, 6.0, 5.0, 'Azul veteado.',            'https://upload.wikimedia.org/wikipedia/commons/f/ff/Sodalith_-_Rohstein.jpg'),
    ('Jaspe Rojo',      3, 10.00, false, NULL,      '2024-04-02', NULL,   7.0, 5.0, 5.0, 'El primo rojo del jade.',  'https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Jasper.pebble.600pix.bkg.jpg/250px-Jasper.pebble.600pix.bkg.jpg'),
    ('Calcita Óptica',  3, 35.00, false, 'Islandia','2024-04-10', 150.0,  5.0, 5.0, 4.0, NULL,                       'https://www.laboiteacailloux.com/cdn/shop/files/IMG-5836.jpg');

INSERT INTO productos (nombre, id_categoria, precio, agotado, origen, fecha_ingreso,
                       peso, ancho, alto, largo, descripcion, imagen) VALUES
    ('Pirita Cúbica',      4,  45.00, false, 'España', '2024-01-30', NULL,  6.0, 6.0, 6.0, 'Cubos dorados.',                    'https://geotierra.es/382-large_default/pirita-cubica-maclada.jpg'),
    ('Bismuto Cristal',    4,  55.00, false, NULL,     '2024-02-15', NULL,  7.0, 5.0, 5.0, 'El arcoíris en la palma de la mano.','https://vivescortadaimport.com/diccionario-minerales/minerales/bismuto/bismuto.jpg'),
    ('Galena',             4,  30.00, false, NULL,     '2024-03-05', 500.0, 6.0, 5.0, 5.0, 'Mena pesada.',                      'https://cdn.britannica.com/14/123814-050-64B5AC94/Galena.jpg'),
    ('Fluorita Octaédrica',4,  65.00, true,  NULL,     '2024-03-22', NULL,  5.0, 5.0, 5.0, 'Colores flúor.',                    'https://www.fabreminerals.com/specimens/s_imagesAL8/Fluorite-DC68AL8fm.jpg'),
    ('Magnetita',          4,  25.00, false, 'Suecia', '2024-04-05', NULL,  8.0, 7.0, 6.0, 'Imán natural.',                     'https://gemascanarias.com/img/cms/piedra-magnetita.jpg'),
    ('Antimonita',         4, 110.00, false, 'Japón',  '2024-04-15', 350.0,15.0, 3.0, 3.0, 'No te pinches.',                    'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDeXcTjRi8KLGuXbZyhqoaO5gm4DlJehcJtw&s');

INSERT INTO productos (nombre, id_categoria, precio, agotado, origen, fecha_ingreso,
                       peso, ancho, alto, largo, descripcion, imagen) VALUES
    ('Ammonite Cleoniceras',  5, 120.00, false, NULL,        '2024-01-20', NULL, 14.0,12.0, 3.0, 'Corte pulido.',  'https://upload.wikimedia.org/wikipedia/commons/b/ba/Cleoniceras_besairiei_Collignon_Alb_inf_Madagascar.JPG'),
    ('Trilobite Calymene',    5,  85.00, false, NULL,        '2024-02-12', 300.0, 9.0, 6.0, 4.0, 'Paleozoico.',    'https://m.media-amazon.com/images/I/91WpRnK+tFL.jpg'),
    ('Diente de Megalodón',   5, 450.00, false, NULL,        '2024-02-25', NULL, 12.0,15.0, 4.0, NULL,             'https://cdn.webshopapp.com/shops/329671/files/478582099/756x1008x3/diente-de-megalodon-the-mutant-us-127-cm.jpg'),
    ('Madera Petrificada',    5,  70.00, false, 'Indonesia', '2024-03-10', NULL, 20.0,15.0, 5.0, NULL,             'https://easycdn.es/4/productos/img_41490.jpg'),
    ('Libélula en Ámbar',     5, 950.00, true,  NULL,        '2024-03-28',  15.0, 3.0, 2.0, 1.5, NULL,             'https://static.wikia.nocookie.net/outlander/images/a/ab/Lib%C3%A9lula_en_%C3%A1mbar.jpg'),
    ('Diente de Espinosaurio',5, 140.00, false, 'Marruecos', '2024-04-10',  80.0, 2.5, 8.0, 2.5, 'Cretácico.',    'https://m.media-amazon.com/images/I/21zgNOW7wHL._AC_UF894,1000_QL80_.jpg');
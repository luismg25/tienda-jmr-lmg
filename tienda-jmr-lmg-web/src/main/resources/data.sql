-- MARCAS
INSERT INTO marcas (nombre) VALUES
    ('Pico y Pala SL.'),
    ('Geólogos sin fronteras'),
    ('R.O.C.K.'),
    ('Amazon'),
    ('Segunda mano'),
    ('Bedrock');

-- CATEGORIAS
INSERT INTO categorias (nombre, descripcion, imagen) VALUES
    ('Gemas Preciosas',     'Piedras de alta pureza y valor gemológico.',         'gemas.jpg'),
    ('Piedras Ornamentales','Piedras estéticas de gama media para decoración.',   'ornamentales.jpg'),
    ('Piedras Comunes',     'Rocas y piedras abundantes de uso general.',         'comunes.jpg'),
    ('Minerales',           'Especímenes cristalinos y menas metálicas.',         'minerales.jpg'),
    ('Fósiles',             'Restos orgánicos mineralizados de eras geológicas.', 'fosiles.jpg'),
    ('Próximamente...',     '¡Novedades dentro de poco!',                         NULL);

-- PRODUCTOS
INSERT INTO productos (nombre, id_marca, precio, descuento, agotado, origen, fecha_ingreso, peso, dimensiones, descripcion, imagen) VALUES
    ('Diamante Azul',        1, 12000.00, NULL, false, NULL,         '2024-01-10', NULL,  '1.1x1.1x0.9',  'Rareza extrema.',          'https://www.naturaldiamonds.com/wp-content/uploads/2025/03/HIS_AUC_Francois-Curiel-profile_7634-lot-212-The-Wittelsbach-Blue_IMG_4x5.jpg'),
    ('Rubí Sangre',          2, 4500.00,  15,   false, NULL,         '2024-02-05', 1.2,   '0.8x1.2x0.6',  'Color rojo intenso.',      'https://imgcdn1.gempundit.com/media/catalog/product/g/p1/gp55623-1-130521.jpg'),
    ('Esmeralda',            3, 3800.00,  NULL, true,  'Colombia',   '2024-02-15', 2.1,   '1.4x1.5x1.0',  NULL,                       'https://jrcolombianemeralds.com/cdn/shop/files/jr-colombian-emeralds-default-title-3-86-carat-deep-emerald-green-natural-loose-colombian-emerald-oval-cut-23042052980830.jpg'),
    ('Zafiro Real',          4, 5100.00,  NULL, false, 'Sri Lanka',  '2024-03-01', 1.7,   '1.0x1.0x0.9',  'Azul real.',               'https://www.claudiahamann.com/hmn/uploads/2019/06/ClaudiaHamann_Sapphire_Ceylon_Octagon_RoyalBlue_452cts_.jpg'),
    ('Alejandrita',          5, 7200.00,  NULL, false, NULL,         '2024-03-20', NULL,  '0.6x0.6x0.5',  NULL,                       'https://omiprive.com/wp-content/uploads/2023/08/Alexandrite_new.jpg'),
    ('Espinela Roja',        6, 1800.00,  10,   false, 'Tanzania',   '2024-04-01', 3.0,   '1.2x1.2x1.0',  NULL,                       'https://marcelvermeulen.com/cdn/shop/articles/spinel_blog.jpg'),
    ('Lapislázuli Extra',    1, 150.00,   NULL, false, 'Afganistán', '2024-01-15', NULL,  '8.0x10.0x5.0', 'Azul intenso.',            'https://www.templodebuda.com/wp-content/uploads/2019/11/Lapis-Lazuli-Pequeno-Extra-scaled.jpg'),
    ('Malaquita Pulida',     2, 85.00,    NULL, false, NULL,         '2024-02-10', NULL,  '6.0x7.0x4.0',  'Bandas verdes.',           'https://m.media-amazon.com/images/I/61nI0P-+cdL._AC_UF894,1000_QL80_.jpg'),
    ('Rodocrosita',          3, 120.00,   25,   false, 'Argentina',  '2024-02-28', 200.0, '5.0x5.0x4.0',  NULL,                       'https://museomine.unizar.es/wp-content/uploads/2022/04/Rodocrosita-ER96H1f.jpg'),
    ('Jade Nefrita',         4, 210.00,   NULL, false, NULL,         '2024-03-15', 450.0, '6.0x12.0x2.0', 'Símbolo de buena suerte.','https://mineraly.es/media/cache/square_600/product/2024/01/12561/jade-nephrite-145.jpg'),
    ('Turquesa Natural',     5, 95.00,    NULL, true,  NULL,         '2024-04-05', NULL,  '3.0x4.0x2.0',  'Azul cielo.',              'https://upload.wikimedia.org/wikipedia/commons/b/b8/Turquoise.pebble.700pix.jpg'),
    ('Amatista Geoda',       6, 180.00,   NULL, false, 'Uruguay',    '2024-04-12', 1200.0,'12.0x15.0x10.0','Cristal violeta.',        'https://sylviacrystals.com/cdn/shop/files/Amethyst-geode-Sylvia-Crystals-Sp.-z-o.o.-44643937.png'),
    ('Obsidiana Negra',      1, 25.00,    NULL, false, 'México',     '2024-01-20', NULL,  '10.0x10.0x8.0','Vidrio volcánico.',        'https://m.media-amazon.com/images/I/61AwATe82hS._AC_UF894,1000_QL80_.jpg'),
    ('Cuarzo Rosa',          2, 15.00,    NULL, false, 'Brasil',     '2024-02-12', 600.0, '8.0x12.0x8.0', NULL,                       'https://cdn.shopify.com/s/files/1/0266/2688/3633/files/Metaphysical_and_Healing_Properties_Lore_480x480.jpg'),
    ('Ágata Cornalina',      3, 12.00,    40,   false, NULL,         '2024-03-05', NULL,  '4.0x5.0x3.0',  NULL,                       'https://vivescortadaimport.com/diccionario-minerales/minerales/cornalina/cornalina.jpg'),
    ('Sodalita',             4, 20.00,    NULL, false, NULL,         '2024-03-18', 300.0, '6.0x8.0x5.0',  'Azul veteado.',            'https://upload.wikimedia.org/wikipedia/commons/f/ff/Sodalith_-_Rohstein.jpg'),
    ('Jaspe Rojo',           5, 10.00,    NULL, false, NULL,         '2024-04-02', NULL,  '5.0x7.0x5.0',  'El primo rojo del jade.',  'https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Jasper.pebble.600pix.bkg.jpg/250px-Jasper.pebble.600pix.bkg.jpg'),
    ('Calcita Óptica',       6, 35.00,    5,    false, 'Islandia',   '2024-04-10', 150.0, '5.0x5.0x4.0',  NULL,                       'https://www.laboiteacailloux.com/cdn/shop/files/IMG-5836.jpg'),
    ('Pirita Cúbica',        1, 45.00,    NULL, false, 'España',     '2024-01-30', NULL,  '6.0x6.0x6.0',  'Cubos dorados.',           'https://geotierra.es/382-large_default/pirita-cubica-maclada.jpg'),
    ('Bismuto Cristal',      2, 55.00,    NULL, false, NULL,         '2024-02-15', NULL,  '5.0x7.0x5.0',  'El arcoíris en la palma.', 'https://vivescortadaimport.com/diccionario-minerales/minerales/bismuto/bismuto.jpg'),
    ('Galena',               3, 30.00,    NULL, false, NULL,         '2024-03-05', 500.0, '5.0x6.0x5.0',  'Mena pesada.',             'https://cdn.britannica.com/14/123814-050-64B5AC94/Galena.jpg'),
    ('Fluorita Octaédrica',  4, 65.00,    50,   true,  NULL,         '2024-03-22', NULL,  '5.0x5.0x5.0',  'Colores flúor.',           'https://www.fabreminerals.com/specimens/s_imagesAL8/Fluorite-DC68AL8fm.jpg'),
    ('Magnetita',            5, 25.00,    NULL, false, 'Suecia',     '2024-04-05', NULL,  '7.0x8.0x6.0',  'Imán natural.',            'https://gemascanarias.com/img/cms/piedra-magnetita.jpg'),
    ('Antimonita',           6, 110.00,   NULL, false, 'Japón',      '2024-04-15', 350.0, '3.0x15.0x3.0', 'No te pinches.',           'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDeXcTjRi8KLGuXbZyhqoaO5gm4DlJehcJtw&s'),
    ('Ammonite Cleoniceras', 1, 120.00,   10,   false, NULL,         '2024-01-20', NULL,  '12.0x14.0x3.0','Corte pulido.',            'https://upload.wikimedia.org/wikipedia/commons/b/ba/Cleoniceras_besairiei_Collignon_Alb_inf_Madagascar.JPG'),
    ('Trilobite Calymene',   2, 85.00,    NULL, false, NULL,         '2024-02-12', 300.0, '6.0x9.0x4.0',  'Paleozoico.',              'https://m.media-amazon.com/images/I/91WpRnK+tFL.jpg'),
    ('Diente de Megalodón',  3, 450.00,   NULL, false, NULL,         '2024-02-25', NULL,  '15.0x12.0x4.0',NULL,                       'https://cdn.webshopapp.com/shops/329671/files/478582099/756x1008x3/diente-de-megalodon-the-mutant-us-127-cm.jpg'),
    ('Madera Petrificada',   4, 70.00,    NULL, false, 'Indonesia',  '2024-03-10', NULL,  '15.0x20.0x5.0',NULL,                       'https://easycdn.es/4/productos/img_41490.jpg'),
    ('Libélula en Ámbar',    5, 950.00,   NULL, true,  NULL,         '2024-03-28', 15.0,  '3.0x2.0x1.5',  NULL,                       'https://static.wikia.nocookie.net/outlander/images/a/ab/Lib%C3%A9lula_en_%C3%A1mbar.jpg'),
    ('Diente Espinosaurio',  6, 140.00,   20,   false, 'Marruecos',  '2024-04-10', 80.0,  '8.0x2.5x2.5',  'Cretácico.',               'https://m.media-amazon.com/images/I/21zgNOW7wHL._AC_UF894,1000_QL80_.jpg'),
    ('Ópalo de Fuego',       2, 800.00,   NULL, false, 'México',     '2024-05-01', 5.0,   '2.0x2.0x1.0',  'Reflejos ardientes.',      'https://vivescortadaimport.com/diccionario-minerales/minerales/opalo-de-fuego/opalo-de-fuego.jpg'),
    ('Citrino Natural',      1, 45.00,    10,   false, 'Brasil',     '2024-05-02', 150.0, '6.0x4.0x4.0',  'Cuarzo amarillo.',         'https://m.media-amazon.com/images/I/61RC3pE6P4L.jpg'),
    ('Meteorito Metálico',   3, 1500.00,  NULL, false, 'Argentina',  '2024-05-03', 800.0, '10.0x8.0x6.0', 'Caído del espacio.',       'https://media.litosphera.com/product/meteorito-ferrico-800x800_7pRMTfm.jpg?width=1200'),
    ('Piedra Pómez',         4, 5.00,     NULL, false, 'España',     '2024-05-04', 20.0,  '10.0x10.0x8.0','Piedra flotante.',         'https://www.icasa.com/wp-content/uploads/2022/11/pom3-piedra-pomez-natural_general_12577.jpg'),
    ('Geoda de Cuarzo',      5, 60.00,    30,   false, 'Marruecos',  '2024-05-05', 400.0, '12.0x10.0x8.0','Interior cristalizado.',   'https://m.media-amazon.com/images/I/81sdvUEwKqL.jpg'),
    ('Larimar',              6, 120.00,   NULL, true,  'Rep. Dom.',  '2024-05-06', 15.0,  '3.0x2.0x1.5',  NULL,                       'https://www.lithotherapie.net/wp-content/uploads/2022/11/Pierre-associee-larimar.jpg'),
    ('Azurita Cristalizada', 1, 95.00,    15,   false, 'EEUU',       '2024-05-07', 80.0,  '5.0x4.0x3.0',  'Azul profundo.',           'https://cristalljoia.com/751-large_default/azurita-mineral-cristalizado-marruecos.jpg'),
    ('Coprolito',            2, 25.00,    NULL, false, 'EEUU',       '2024-05-08', 300.0, '8.0x5.0x4.0',  'Heces fosilizadas.',       'https://media.litosphera.com/product/coprolito-de-dinosaurio-ref-3-800x800.jpg?width=1200'),
    ('Cinabrio en Matriz',   3, 50.00,    NULL, false, 'China',      '2024-05-09', 250.0, '6.0x5.0x4.0',  'Mineral tóxico.',          'https://crapzetesoros.com/65825-large_default/cinabrios-cristalizados-en-matriz-de-almaden-espana.jpg'),
    ('Roca Lunar (Simulación)',4, 15.00,  NULL, false, 'Laboratorio','2024-05-10', 50.0,  '4.0x4.0x4.0',  'Imitación perfecta.',      'https://robotitus.com/wp-content/uploads/2021/11/Roca-lunar.jpg');

-- ASIGNACIÓN DE CATEGORÍAS
INSERT INTO productos_categorias (id_producto, id_categoria) VALUES
     (1,1), (2,1), (3,1), (4,1), (5,1), (6,1),
     (7,2), (8,2), (9,2), (10,2), (11,2), (12,2),
     (13,3), (14,3), (15,3), (16,3), (17,3), (18,3),
     (19,4), (20,4), (21,4), (22,4), (23,4), (24,4),
     (25,5), (26,5), (27,5), (28,5), (29,5), (30,5),
     (31,1), (32,2), (32,4), (33,4), (35,2), (35,4),
     (36,1), (37,4), (38,5), (39,4), (12, 4), (18, 4),
     (22, 1), (14, 1);



--
-- Dumping data for table `item`
--

/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`ID_ITEM`,`VC_REFERENCIA`) VALUES 
 (1,'ref1'),
 (2,'ref2'),
 (3,'ref3'),
 (4,'ref4'),
 (5,'ref5'),
 (6,'ref6'),
 (7,'ref7'),
 (8,'ref8'),
 (9,'ref9'),
 (10,'ref10'),
 (11,'ref11'),
 (12,'ref12'),
 (13,'ref13'),
 (14,'ref14'),
 (15,'ref15'),
 (16,'ref16'),
 (17,'ofert17'),
 (18,'ofert18'),
 (19,'ofert19'),
 (20,'ofert20'),
 (21,'ref21');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;



--
-- Dumping data for table `producto`
--

/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`ID_ITEM_3`,`VC_MARCA`,`VC_MODELO`,`VC_DIMENSIONES`,`MO_PRECIO`,`IN_GANANCIA`,`VC_DESCRIPCION`,`VC_FOTO`) VALUES 
 (1,'Sony','KV14CT1','Alto 80 cm-Ancho 70 cm',215.00,0,'Televisor pequeño, compacto y mono.','Sony_KV_14_CT1.jpg'),
 (2,'Fagor','F 2810','Alto 85 cm-Ancho 59 cm',439.00,0,'Lavadora con carga frontal, cuba de acero inoxidable con una capacidad 8kg.','Fagor_F_2810.jpg'),
 (3,'Fagor','3FC 67 NFXD','Alto 185 cm-Ancho 60 cm',699.00,0,'Frigorifico de gran capacidad, con controles de firgorifico y congelador separados','Fagor_3FC_67_NFXD.jpg'),
 (4,'Zanussi','ZNB 34 NDX','Alto 185 cm-Ancho 60 cm',456.00,0,'Figrorifico con ventilador interno para distribuir el frio, puerta de acero inoxidable y bandejas de cristal.','Zanussi_ZNB_34_NDX.jpg'),
 (5,'Bosch','KGU 34175 EU','Alto 186 cm-Ancho 60 cm',465.00,0,'Frigorifico con dos motores, de acero inoxidable y bandejas de cristal.','Bosch_KGU_34175_EU.jpg'),
 (6,'Bosch','KGU 44170 eu','Alto 201cm-Ancho 70cm',1081.58,0,'Frigorifico de acero inoxidable con dos motores y controles frigorifico-congelador separados.','Bosch_KGU_44170_EU'),
 (7,'Philips','21 PT 5402','Alto 30 cm-Ancho 40 cm',179.52,0,'Televisor con gran calidad de imagen, compacto, estereo y con teletexto.','Philips_21_PT_5402.jpg');
INSERT INTO `producto` (`ID_ITEM_3`,`VC_MARCA`,`VC_MODELO`,`VC_DIMENSIONES`,`MO_PRECIO`,`IN_GANANCIA`,`VC_DESCRIPCION`,`VC_FOTO`) VALUES 
 (8,'Philips','29 PT 5458','Alto 50 cm- Ancho 60 cm',499.00,0,'Televisor con gran calidad de imagen y sonido, estereo y con teletexto.','Philips_29_PT_5458.jpg'),
 (9,'Panasonic','TX-26 LXD 65 F','Alto 90 cm-Ancho 110 cm',824.53,0,'Televisor con sonido envolvente, programable y pantalla LCD.','Panasonic_TX_26_LXD_65_F.jpg'),
 (10,'Panasonic','TX-26LX60F','Alto 95 cm-Ancho 110 cm',895.00,0,'Televisor con pantalla LCD con gran calidad de imagen y sonido envolvente.','Panasonic_TX_26LX60F.jpg'),
 (11,'Zanussi','ZWG-3125','Alto 85 cm-Ancho 60 cm',349.00,0,'Lavadora con sistema antidesbordamiento, carga frontal y cuba de plastico de 6 kg de capacidad.','Zanussi_ZWG_3125.jpg'),
 (12,'Fagor','F2812','Alto 85 cm-Ancho 59 cm',499.00,0,'Lavadora con cuba de acero inosidable y con 8 kg de carga.','Fagor_F_2812.jpg'),
 (13,'Whirlpool','FL-5085','Alto 85 cm-Ancho 60 cm',380.50,0,'Lavadora de carga frontal con una capacidad de 5 kg.','Whirlpool_FL_5085.jpg'),
 (14,'Whirlpool','AWM-7106','Alto 85 cm-Ancho 60 cm',320.75,0,'Lavadora con cuba de plástico de 5 kg de capacidad y carga frontal.','Whirlpool_AWM_7106.jpg');
INSERT INTO `producto` (`ID_ITEM_3`,`VC_MARCA`,`VC_MODELO`,`VC_DIMENSIONES`,`MO_PRECIO`,`IN_GANANCIA`,`VC_DESCRIPCION`,`VC_FOTO`) VALUES 
 (15,'Panasonic','DVD-LS91','Altura 2.03 in-Ancho 9.28 in-Profundidad 7.28',194.99,0,'Esta impresionante pantalla de 9\" en este reproductor de DVD portátil es ideal para películas en el asiento trasero durante un viaje largo. La entrada dual para audífonos permite que dos personas oigan simultáneamente.','Panasonic DVD-LS91.jpg'),
 (16,'Philips','HR-2094','1.5l',86.20,0,'Pequeña batidora','Philips_HR_2094__550219.jpg'),
 (21,'Taurus','BAPI 600 IX','Pequeña',28.59,0,'Pequeña batidora.','Taurus_BAPI_600_IX.jpg');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;



--
-- Dumping data for table `dvd`
--

/*!40000 ALTER TABLE `dvd` DISABLE KEYS */;
INSERT INTO `dvd` (`ID_ITEM_3`,`VC_FORMATO`,`VC_CONECTORES_IO`) VALUES 
 (15,'Audio CD,CD-R,CD-RW,DVD,DVD Audio,DVD+R,DVD+R DL,DVD+RW,DVD-R,DVD-R DL,DVD-RAM\r\n','Entrada:Digital Optical Audio. Salida de Audio: Digital Optical,Headphone Out (1/8\" Mini). Salida de Video: Composite (RCA).');
/*!40000 ALTER TABLE `dvd` ENABLE KEYS */;


--
-- Dumping data for table `frigorifico`
--

/*!40000 ALTER TABLE `frigorifico` DISABLE KEYS */;
INSERT INTO `frigorifico` (`ID_ITEM_3`,`COMBI`,`VC_CLASIFENERGETICA`) VALUES 
 (3,0,'A'),
 (4,0,'A'),
 (5,0,'A'),
 (6,0,'A');
/*!40000 ALTER TABLE `frigorifico` ENABLE KEYS */;




--
-- Dumping data for table `lavadora`
--

/*!40000 ALTER TABLE `lavadora` DISABLE KEYS */;
INSERT INTO `lavadora` (`ID_ITEM_3`,`BO_SECADORA`,`VC_CLASIFENERGETICA`) VALUES 
 (2,0,'A+'),
 (11,1,'A+'),
 (12,0,'A+'),
 (13,0,'B'),
 (14,0,'B');
/*!40000 ALTER TABLE `lavadora` ENABLE KEYS */;



--
-- Dumping data for table `pequeno_electrodomestico`
--

/*!40000 ALTER TABLE `pequeno_electrodomestico` DISABLE KEYS */;
INSERT INTO `pequeno_electrodomestico` (`ID_ITEM_3`,`VC_CARACTERISTICAS`) VALUES 
 (16,'Batidora con vaso de plático y de velocidad variable. Carece de accesori para la minipicadora.'),
 (21,'Batidora con pie de metal, con envases para batir de diferentes tamaños.');
/*!40000 ALTER TABLE `pequeno_electrodomestico` ENABLE KEYS */;



--
-- Dumping data for table `televisor`
--

/*!40000 ALTER TABLE `televisor` DISABLE KEYS */;
INSERT INTO `televisor` (`ID_ITEM_3`,`VC_TAMANO`,`TDT`,`PEANA`) VALUES 
 (1,'14 pulgadas',0,0),
 (7,'21 pulgadas',0,0),
 (8,'29 pulgadas',0,0),
 (9,'26 pulgadas',0,1),
 (10,'26 pulgadas',0,1);
/*!40000 ALTER TABLE `televisor` ENABLE KEYS */;




--
-- Dumping data for table `oferta`
--

/*!40000 ALTER TABLE `oferta` DISABLE KEYS */;
INSERT INTO `oferta` (`ID_ITEM_2`,`ID_ITEM_3`,`PRO_ID_ITEM_3`) VALUES 
 (17,16,1),
 (18,21,6),
 (19,21,10),
 (20,16,7);
/*!40000 ALTER TABLE `oferta` ENABLE KEYS */;


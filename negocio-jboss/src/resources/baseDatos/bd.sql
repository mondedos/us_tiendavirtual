/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     13/06/2007 19:08:57                          */
/*==============================================================*/


/*==============================================================*/
/* Table: BENEFICIO                                             */
/*==============================================================*/
create table BENEFICIO
(
   ID_ITEM_5            int not null,
   IN_GANANCIA          int not null,
   primary key (ID_ITEM_5)
);

/*==============================================================*/
/* Table: DEPRECATED                                            */
/*==============================================================*/
create table DEPRECATED
(
   ID_ITEM_4            int not null,
   FECHA                date not null,
   primary key (ID_ITEM_4)
);

/*==============================================================*/
/* Table: DVD                                                   */
/*==============================================================*/
create table DVD
(
   ID_ITEM_3            int not null,
   VC_FORMATO           varchar(1024) not null,
   VC_CONECTORES_IO     varchar(1024) not null,
   primary key (ID_ITEM_3)
);

/*==============================================================*/
/* Table: FRIGORIFICO                                           */
/*==============================================================*/
create table FRIGORIFICO
(
   ID_ITEM_3            int not null,
   COMBI                bool not null,
   VC_CLASIFENERGETICA  varchar(50),
   primary key (ID_ITEM_3)
);

/*==============================================================*/
/* Table: IDENTIFICADORHIBERNATE                                */
/*==============================================================*/
create table IDENTIFICADORHIBERNATE
(
   PRIMARY_KEY          int not null,
   GENERADOR_ITEM       int not null,
   GENERADOR_PEDIDO     int not null,
   GENERADOR_LP         int not null,
   GENERADOR_OPERADOR   int not null,
   primary key (PRIMARY_KEY)
);

/*==============================================================*/
/* Table: ITEM                                                  */
/*==============================================================*/
create table ITEM
(
   ID_ITEM              int not null,
   VC_REFERENCIA        varchar(1024),
   primary key (ID_ITEM)
);

/*==============================================================*/
/* Table: LAVADORA                                              */
/*==============================================================*/
create table LAVADORA
(
   ID_ITEM_3            int not null,
   BO_SECADORA          bool not null,
   VC_CLASIFENERGETICA  varchar(50),
   primary key (ID_ITEM_3)
);

/*==============================================================*/
/* Table: LINEA_PEDIDO                                          */
/*==============================================================*/
create table LINEA_PEDIDO
(
   ID_LINEA             int not null,
   ID_ITEM              int,
   ID_PEDIDO            int,
   MO_PRECIO_UNIDAD     float(8,2),
   IN_UNIDADES          int,
   primary key (ID_LINEA)
);

/*==============================================================*/
/* Table: OFERTA                                                */
/*==============================================================*/
create table OFERTA
(
   ID_ITEM_2            int not null,
   ID_ITEM_3            int,
   PRO_ID_ITEM_3        int,
   ACTUAL				bool not null,
   primary key (ID_ITEM_2)
);

/*==============================================================*/
/* Table: OPERADOR                                              */
/*==============================================================*/
create table OPERADOR
(
   ID_OPERADOR          int not null,
   VC_LOGIN             varchar(1024) not null,
   primary key (ID_OPERADOR)
);

/*==============================================================*/
/* Table: PEDIDO                                                */
/*==============================================================*/
create table PEDIDO
(
   ID_PEDIDO            int not null,
   ID_OPERADOR          int,
   MO_PRECIO_TOTAL      float(8,2) not null,
   VC_DIRECCION         varchar(1024) not null,
   FECHA_PLACED         date,
   FECHA_CANCELLED      date,
   FECHA_TRANSIENT      date,
   FECHA_SERVED         date,
   primary key (ID_PEDIDO)
);

/*==============================================================*/
/* Table: PEQUENO_ELECTRODOMESTICO                              */
/*==============================================================*/
create table PEQUENO_ELECTRODOMESTICO
(
   ID_ITEM_3            int not null,
   VC_CARACTERISTICAS   varchar(1024) not null,
   primary key (ID_ITEM_3)
);

/*==============================================================*/
/* Table: PRODUCTO                                              */
/*==============================================================*/
create table PRODUCTO
(
   ID_ITEM_3            int not null,
   VC_MARCA             varchar(1024),
   VC_MODELO            varchar(1024),
   VC_DIMENSIONES       varchar(1024),
   MO_PRECIO            float(8,2),
   IN_GANANCIA          int,
   VC_DESCRIPCION       varchar(2000),
   VC_FOTO              varchar(1024),
   primary key (ID_ITEM_3)
);

/*==============================================================*/
/* Index: IND_PROD                                              */
/*==============================================================*/
create unique index IND_PROD on PRODUCTO
(
   ID_ITEM_3
);

/*==============================================================*/
/* Table: TELEVISOR                                             */
/*==============================================================*/
create table TELEVISOR
(
   ID_ITEM_3            int not null,
   VC_TAMANO            varchar(1024) not null,
   TDT                  bool not null,
   PEANA                bool not null,
   primary key (ID_ITEM_3)
);

alter table BENEFICIO add constraint FK_BENEFICIO_PRODUCTO foreign key (ID_ITEM_5)
      references PRODUCTO (ID_ITEM_3) on delete restrict on update restrict;

alter table DEPRECATED add constraint FK_DEPRECATED_PRODUCTO foreign key (ID_ITEM_4)
      references PRODUCTO (ID_ITEM_3) on delete restrict on update restrict;

alter table DVD add constraint FK_DVD_PRODUCTO foreign key (ID_ITEM_3)
      references PRODUCTO (ID_ITEM_3) on delete restrict on update restrict;

alter table FRIGORIFICO add constraint FK_FRIGORIFICO_PRODUCTO foreign key (ID_ITEM_3)
      references PRODUCTO (ID_ITEM_3) on delete restrict on update restrict;

alter table LAVADORA add constraint FK_LAVADORA_PRODUCTO foreign key (ID_ITEM_3)
      references PRODUCTO (ID_ITEM_3) on delete restrict on update restrict;

alter table LINEA_PEDIDO add constraint FK_LP_ITEM foreign key (ID_ITEM)
      references ITEM (ID_ITEM) on delete restrict on update restrict;

alter table LINEA_PEDIDO add constraint FK_LP_PEDIDO foreign key (ID_PEDIDO)
      references PEDIDO (ID_PEDIDO) on delete restrict on update restrict;

alter table OFERTA add constraint FK_OFERTA_ITEM foreign key (ID_ITEM_2)
      references ITEM (ID_ITEM) on delete restrict on update restrict;

alter table OFERTA add constraint FK_OFERTA_PROD1 foreign key (PRO_ID_ITEM_3)
      references PRODUCTO (ID_ITEM_3) on delete restrict on update restrict;

alter table OFERTA add constraint FK_OFERTA_PROD2 foreign key (ID_ITEM_3)
      references PRODUCTO (ID_ITEM_3) on delete restrict on update restrict;

alter table PEDIDO add constraint FK_PEDIDO_OPERADOR foreign key (ID_OPERADOR)
      references OPERADOR (ID_OPERADOR) on delete restrict on update restrict;

alter table PEQUENO_ELECTRODOMESTICO add constraint FK_PE_PRODUCTO foreign key (ID_ITEM_3)
      references PRODUCTO (ID_ITEM_3) on delete restrict on update restrict;

alter table PRODUCTO add constraint FK_PRODUCTO_ITEM foreign key (ID_ITEM_3)
      references ITEM (ID_ITEM) on delete restrict on update restrict;

alter table TELEVISOR add constraint FK_TELEVISOR_PRODUCTO foreign key (ID_ITEM_3)
      references PRODUCTO (ID_ITEM_3) on delete restrict on update restrict;

INSERT INTO `identificadorhibernate` (`PRIMARY_KEY`,`GENERADOR_ITEM`,`GENERADOR_PEDIDO`,`GENERADOR_LP`,`GENERADOR_OPERADOR`) VALUES 
 (0,1,1,1,1);
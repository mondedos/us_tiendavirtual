/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     27/05/2007 6:06:47                           */
/*==============================================================*/


drop table if exists PRODUCTO;

/*==============================================================*/
/* Table: PRODUCTO                                              */
/*==============================================================*/
create table PRODUCTO
(
   ID                   INTEGER not null,
   VERSION              INTEGER,
   NOMBRE               VARCHAR(256),
   DESCRIPCION          VARCHAR(256),
   FOTO                 VARCHAR(50),
   primary key (ID)
);


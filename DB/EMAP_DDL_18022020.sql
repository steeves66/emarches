---------------------------------------------
-- Export file for user EMAP               --
-- Created by USER on 18/02/2020, 18:40:08 --
---------------------------------------------

spool EMAP_DDL_18022020_2.log

prompt
prompt Creating table T_TYPE_STRUCTURE
prompt ===============================
prompt
create table T_TYPE_STRUCTURE
(
  TST_CODE          VARCHAR2(3) not null,
  TST_LIBELLE       VARCHAR2(500),
  TST_DTE_SAISI     DATE,
  TST_OPE_MATRICULE VARCHAR2(20)
)
;
comment on column T_TYPE_STRUCTURE.TST_CODE
  is 'Code du type structure';
comment on column T_TYPE_STRUCTURE.TST_LIBELLE
  is 'Libelle du type de structure';
comment on column T_TYPE_STRUCTURE.TST_DTE_SAISI
  is 'date de saisie du type de strcuture';
comment on column T_TYPE_STRUCTURE.TST_OPE_MATRICULE
  is 'Matricule de l(acteur de saisie';
alter table T_TYPE_STRUCTURE
  add constraint TST_CODE_PK primary key (TST_CODE);

prompt
prompt Creating table T_MINISTERE
prompt ==========================
prompt
create table T_MINISTERE
(
  MIN_CODE          VARCHAR2(3) not null,
  MIN_LIBELLE       VARCHAR2(1000),
  MIN_LIBELLE_COURT VARCHAR2(500),
  MIN_DESCRIPTION   VARCHAR2(1000)
)
;
comment on table T_MINISTERE
  is 'Liste des Ministères';
comment on column T_MINISTERE.MIN_CODE
  is 'Code du Ministère';
comment on column T_MINISTERE.MIN_LIBELLE
  is 'Libellé long du Ministère';
comment on column T_MINISTERE.MIN_LIBELLE_COURT
  is 'Libellé Court du Ministère';
comment on column T_MINISTERE.MIN_DESCRIPTION
  is 'Descripion du Ministère';
alter table T_MINISTERE
  add constraint PK_T_MINISTERE primary key (MIN_CODE);

prompt
prompt Creating table T_REGION
prompt =======================
prompt
create table T_REGION
(
  REG_CODE          VARCHAR2(10) not null,
  REG_LIBELLE       VARCHAR2(500),
  REG_OPE_MATRICULE VARCHAR2(25),
  REG_DTE_SAISI     DATE
)
;
comment on column T_REGION.REG_CODE
  is 'Code de la région';
comment on column T_REGION.REG_LIBELLE
  is 'Libelle de la région';
comment on column T_REGION.REG_OPE_MATRICULE
  is 'Opérateur de la saisie';
comment on column T_REGION.REG_DTE_SAISI
  is 'date de la saisie';
alter table T_REGION
  add constraint REG_CODE_PK primary key (REG_CODE);

prompt
prompt Creating table T_STRUCTURE
prompt ==========================
prompt
create table T_STRUCTURE
(
  STR_CODE          VARCHAR2(3) not null,
  STR_LIBELLE_COURT VARCHAR2(500) not null,
  STR_LIBELLE_LONG  VARCHAR2(1000),
  STR_ADRESSE       VARCHAR2(500),
  STR_EMAIL         VARCHAR2(500),
  STR_MIN_CODE      VARCHAR2(3) not null,
  STR_TST_CODE      VARCHAR2(3),
  STR_REG_CODE      VARCHAR2(10),
  STR_ADR_POST      VARCHAR2(200),
  STR_ADR_GEO       VARCHAR2(200),
  STR_TEL           VARCHAR2(100),
  STR_FAX           VARCHAR2(50),
  STR_OPE_MATRICULE VARCHAR2(25),
  STR_DTE_SAISI     DATE,
  STR_OPE_RESPO     VARCHAR2(1)
)
;
comment on table T_STRUCTURE
  is 'Liste des STRUCTURES (DAAF, Cellule de passation ou Autre Structure, ...) ';
comment on column T_STRUCTURE.STR_CODE
  is 'Code du TYPE_DAO';
comment on column T_STRUCTURE.STR_LIBELLE_COURT
  is 'Nom Court de la Structure';
comment on column T_STRUCTURE.STR_LIBELLE_LONG
  is 'Nom Integral de la Structure';
comment on column T_STRUCTURE.STR_ADRESSE
  is 'Adresse de la Structure';
comment on column T_STRUCTURE.STR_EMAIL
  is 'Mail de la Structure';
comment on column T_STRUCTURE.STR_MIN_CODE
  is 'Code du Ministere';
comment on column T_STRUCTURE.STR_TST_CODE
  is 'Code type Structure';
comment on column T_STRUCTURE.STR_REG_CODE
  is 'Code de la reglementation';
comment on column T_STRUCTURE.STR_ADR_POST
  is 'Adresse postale';
comment on column T_STRUCTURE.STR_ADR_GEO
  is 'Adresse géographique';
comment on column T_STRUCTURE.STR_TEL
  is 'Téléphone de la structure';
comment on column T_STRUCTURE.STR_FAX
  is 'Fax de la structure';
comment on column T_STRUCTURE.STR_OPE_MATRICULE
  is 'Opérateur de saisie';
comment on column T_STRUCTURE.STR_DTE_SAISI
  is 'Date de Saisie';
alter table T_STRUCTURE
  add constraint STR_PK primary key (STR_CODE);
alter table T_STRUCTURE
  add constraint FK_STR_MIN_CODE foreign key (STR_MIN_CODE)
  references T_MINISTERE (MIN_CODE);
alter table T_STRUCTURE
  add constraint STR_REG_CODE_FK foreign key (STR_REG_CODE)
  references T_REGION (REG_CODE);
alter table T_STRUCTURE
  add constraint STR_TST_CODE_FK foreign key (STR_TST_CODE)
  references T_TYPE_STRUCTURE (TST_CODE);

prompt
prompt Creating table T_TYPE_FONCTION
prompt ==============================
prompt
create table T_TYPE_FONCTION
(
  TYF_COD     VARCHAR2(3) not null,
  TYF_LIBELLE VARCHAR2(100)
)
;
alter table T_TYPE_FONCTION
  add constraint PK_T_TYPE_FONCTION primary key (TYF_COD);

prompt
prompt Creating table T_FONCTION
prompt =========================
prompt
create table T_FONCTION
(
  FON_COD      VARCHAR2(12) not null,
  FON_TYF_COD  VARCHAR2(3),
  FON_DAT_DEB  DATE,
  FON_DAT_FIN  DATE,
  FON_LIBELLE  VARCHAR2(240),
  FON_ADR      VARCHAR2(240),
  FON_TEL      VARCHAR2(240),
  FON_FON_COD  VARCHAR2(12),
  FON_COURRIEL VARCHAR2(100),
  FON_MOBIL    VARCHAR2(20),
  FON_STR_CODE VARCHAR2(3)
)
;
alter table T_FONCTION
  add constraint PK_T_FONCTION primary key (FON_COD);
alter table T_FONCTION
  add constraint FK_T_FON_TYF foreign key (FON_TYF_COD)
  references T_TYPE_FONCTION (TYF_COD);
alter table T_FONCTION
  add constraint FK_T_STR_CODE foreign key (FON_STR_CODE)
  references T_STRUCTURE (STR_CODE);
create index FK_T_F_REL_T_TYF_FK on T_FONCTION (FON_TYF_COD);

prompt
prompt Creating table T_ADRESSE_AVIS
prompt =============================
prompt
create table T_ADRESSE_AVIS
(
  ADA_NUM     NUMBER not null,
  ADA_LIBELLE VARCHAR2(500),
  ADA_FON_COD VARCHAR2(12)
)
;
comment on column T_ADRESSE_AVIS.ADA_NUM
  is 'Code de l''adresse';
comment on column T_ADRESSE_AVIS.ADA_LIBELLE
  is 'Libelle de l''adresse';
comment on column T_ADRESSE_AVIS.ADA_FON_COD
  is 'Fonction de l''autorité contractante';
alter table T_ADRESSE_AVIS
  add constraint ADA_NUM_PK primary key (ADA_NUM);
alter table T_ADRESSE_AVIS
  add constraint ADA_FON_CODE_FK foreign key (ADA_FON_COD)
  references T_FONCTION (FON_COD);

prompt
prompt Creating table T_BAILLEUR
prompt =========================
prompt
create table T_BAILLEUR
(
  BAI_CODE      VARCHAR2(5) not null,
  BAI_LIBELLE   VARCHAR2(1000) not null,
  BAI_ADRESSE   VARCHAR2(500),
  BAI_TELEPHONE VARCHAR2(500)
)
;
comment on table T_BAILLEUR
  is 'Bailleur de fonds';
comment on column T_BAILLEUR.BAI_CODE
  is 'Code du bailleur';
comment on column T_BAILLEUR.BAI_LIBELLE
  is 'Libelle du bailleur';
comment on column T_BAILLEUR.BAI_ADRESSE
  is 'Adresse complete du bailleur';
comment on column T_BAILLEUR.BAI_TELEPHONE
  is 'Telephone, fax, e-mail du bailleur';
alter table T_BAILLEUR
  add constraint BAI_PK primary key (BAI_CODE);

prompt
prompt Creating table T_DECLARANT
prompt ==========================
prompt
create table T_DECLARANT
(
  DEC_ID                 NUMBER(10) not null,
  DEC_ORGAN_EXEC_LIBELLE VARCHAR2(500) not null,
  DEC_ORGAN_EXEC_ADRESSE VARCHAR2(500),
  DEC_PERS_NOM_PRENOM    VARCHAR2(500),
  DEC_PERS_FONCTION      VARCHAR2(500) not null,
  DEC_LOCALISATION       VARCHAR2(500),
  DEC_NUMERO_PORTE       VARCHAR2(500),
  DEC_BP                 VARCHAR2(500) not null,
  DEC_TELEPHONE          VARCHAR2(500),
  DEC_EMAIL              VARCHAR2(500),
  DEC_CEL                VARCHAR2(500)
)
;
comment on table T_DECLARANT
  is 'Liste des DECLARANTS';
alter table T_DECLARANT
  add constraint DEC_PK primary key (DEC_ID);

prompt
prompt Creating table T_DEVISE
prompt =======================
prompt
create table T_DEVISE
(
  DEV_CODE    VARCHAR2(8) not null,
  DEV_LIBELLE VARCHAR2(500),
  DEV_SYMBOLE VARCHAR2(500)
)
;
comment on table T_DEVISE
  is 'Liste des devises';
comment on column T_DEVISE.DEV_CODE
  is 'Code de la devise';
comment on column T_DEVISE.DEV_LIBELLE
  is 'Libelle de la devise';
alter table T_DEVISE
  add constraint DEV_PK primary key (DEV_CODE);

prompt
prompt Creating table T_REGLEMENTATION
prompt ===============================
prompt
create table T_REGLEMENTATION
(
  REG_ID            NUMBER(10) not null,
  REG_LIBELLE_COURT VARCHAR2(500),
  REG_LIBELLE_LONG  VARCHAR2(1000)
)
;
comment on table T_REGLEMENTATION
  is 'Liste des reglementations';
comment on column T_REGLEMENTATION.REG_ID
  is 'ID de la reglementation';
comment on column T_REGLEMENTATION.REG_LIBELLE_COURT
  is 'Libelle de la reglementation';
alter table T_REGLEMENTATION
  add constraint REG_PK primary key (REG_ID);

prompt
prompt Creating table T_PROJET
prompt =======================
prompt
create table T_PROJET
(
  PRO_ID              NUMBER(10) not null,
  PRO_REG_ID          NUMBER(10),
  PRO_CODE            VARCHAR2(50),
  PRO_TITRE           VARCHAR2(500) not null,
  PRO_LIBELLE         VARCHAR2(500),
  PRO_DESCRIPTION     VARCHAR2(1000),
  PRO_MONTANT_TOT_CFA NUMBER(15,2) default 0,
  PRO_TYPE_PROJET     VARCHAR2(10)
)
;
comment on table T_PROJET
  is 'Liste des PROJET';
comment on column T_PROJET.PRO_ID
  is 'ID de la PROJET';
comment on column T_PROJET.PRO_CODE
  is 'Code du projet de la PROJET après sa validation';
comment on column T_PROJET.PRO_TITRE
  is 'Titre du projet de la PROJET';
comment on column T_PROJET.PRO_LIBELLE
  is 'Libelle du projet de la PROJET';
comment on column T_PROJET.PRO_DESCRIPTION
  is 'Description du projet de la PROJET';
comment on column T_PROJET.PRO_MONTANT_TOT_CFA
  is 'Montant total du projet de la PROJET en FCFA';
comment on column T_PROJET.PRO_TYPE_PROJET
  is 'Projet (PRO) ou Programme (PGM)';
alter table T_PROJET
  add constraint PRO_PK primary key (PRO_ID);
alter table T_PROJET
  add constraint FK_T_PRO_FK_T_REG foreign key (PRO_REG_ID)
  references T_REGLEMENTATION (REG_ID);
create index FK_T_P_T_R_FK on T_PROJET (PRO_REG_ID);

prompt
prompt Creating table T_SOURCE_FINANCEMENT
prompt ===================================
prompt
create table T_SOURCE_FINANCEMENT
(
  SOU_CODE    VARCHAR2(5) not null,
  SOU_LIBELLE VARCHAR2(500)
)
;
comment on table T_SOURCE_FINANCEMENT
  is 'Liste des sources de financement';
comment on column T_SOURCE_FINANCEMENT.SOU_CODE
  is 'Code de la source de financement';
comment on column T_SOURCE_FINANCEMENT.SOU_LIBELLE
  is 'Libelle de la source de financement';
alter table T_SOURCE_FINANCEMENT
  add constraint SOU_PK primary key (SOU_CODE);

prompt
prompt Creating table T_GESTION
prompt ========================
prompt
create table T_GESTION
(
  GES_CODE       NUMBER(4) not null,
  GES_DATE_DEBUT DATE,
  GES_DATE_FIN   DATE
)
;
comment on table T_GESTION
  is 'Liste des gestions';
comment on column T_GESTION.GES_CODE
  is 'Code de la GESTION';
alter table T_GESTION
  add constraint GES_PK primary key (GES_CODE);

prompt
prompt Creating table T_STATUT
prompt =======================
prompt
create table T_STATUT
(
  STA_CODE          VARCHAR2(3) not null,
  STA_LIBELLE_COURT VARCHAR2(500),
  STA_LIBELLE_LONG  VARCHAR2(1000)
)
;
comment on table T_STATUT
  is 'Liste des STATUTS';
comment on column T_STATUT.STA_CODE
  is 'Code de la STATUT';
alter table T_STATUT
  add constraint STA_PK primary key (STA_CODE);

prompt
prompt Creating table T_AGPM
prompt =====================
prompt
create table T_AGPM
(
  AGP_ID             NUMBER(10) not null,
  AGP_STR_CODE       VARCHAR2(3) not null,
  AGP_FON_COD        VARCHAR2(12) not null,
  AGP_GES_CODE       NUMBER(4) not null,
  AGP_STA_CODE       VARCHAR2(3) not null,
  AGP_PRO_ID         NUMBER(10) not null,
  AGP_DEC_ID         NUMBER(10),
  AGP_COMMENTAIRE    VARCHAR2(1000),
  AGP_TYPE_DAO       VARCHAR2(1000),
  AGP_MODE_PASSATION VARCHAR2(1000),
  AGP_ACTIF          VARCHAR2(1) default 'O',
  AGP_STATUT_RETOUR  VARCHAR2(2),
  AGP_ACTEUR_SAISIE  VARCHAR2(12)
)
;
comment on table T_AGPM
  is 'Histosisation du cycle de vie de  AGPM';
alter table T_AGPM
  add constraint PK_T_AGPM primary key (AGP_ID);
alter table T_AGPM
  add constraint FK_T_AGP_FK_STR foreign key (AGP_STR_CODE)
  references T_STRUCTURE (STR_CODE);
alter table T_AGPM
  add constraint FK_T_AGP_FK_T_DEC foreign key (AGP_DEC_ID)
  references T_DECLARANT (DEC_ID);
alter table T_AGPM
  add constraint FK_T_AGP_FK_T_FON foreign key (AGP_FON_COD)
  references T_FONCTION (FON_COD);
alter table T_AGPM
  add constraint FK_T_AGP_FK_T_GES foreign key (AGP_GES_CODE)
  references T_GESTION (GES_CODE);
alter table T_AGPM
  add constraint FK_T_AGP_FK_T_PRO foreign key (AGP_PRO_ID)
  references T_PROJET (PRO_ID);
alter table T_AGPM
  add constraint FK_T_AGP_FK_T_STA foreign key (AGP_STA_CODE)
  references T_STATUT (STA_CODE);
create index FK_T_AG_R_T_D_FK on T_AGPM (AGP_DEC_ID);
create index FK_T_AG_R_T_F_FK on T_AGPM (AGP_FON_COD);
create index FK_T_AG_R_T_G_FK on T_AGPM (AGP_GES_CODE);
create index FK_T_AG_R_T_M_FK on T_AGPM (AGP_STR_CODE);
create index FK_T_AG_R_T_P_FK on T_AGPM (AGP_PRO_ID);
create index FK_T_AG_R_T_S_FK on T_AGPM (AGP_STA_CODE);

prompt
prompt Creating table T_FINANCEMENT
prompt ============================
prompt
create table T_FINANCEMENT
(
  FIN_ID             NUMBER(10) not null,
  FIN_DEV_CODE       VARCHAR2(8) not null,
  FIN_BAI_CODE       VARCHAR2(5) not null,
  FIN_SOU_CODE       VARCHAR2(5) not null,
  FIN_PRO_ID         NUMBER(10) not null,
  FIN_MONTANT_CFA    NUMBER(15,2) default 0,
  FIN_MONTANT_DEVISE NUMBER(15,2) default 0,
  FIN_NUMERO_ACCORD  VARCHAR2(500),
  FIN_STATUT         VARCHAR2(10) default 'O',
  FIN_AGP_ID         NUMBER(10)
)
;
comment on column T_FINANCEMENT.FIN_MONTANT_CFA
  is 'Montant en FCFA';
comment on column T_FINANCEMENT.FIN_MONTANT_DEVISE
  is 'Montant ne devise correspontante';
comment on column T_FINANCEMENT.FIN_NUMERO_ACCORD
  is 'Numero de l accord';
alter table T_FINANCEMENT
  add constraint PK_T_FINANCEMENT primary key (FIN_ID);
alter table T_FINANCEMENT
  add constraint FK_T_FIN_FK_T_AGP foreign key (FIN_AGP_ID)
  references T_AGPM (AGP_ID);
alter table T_FINANCEMENT
  add constraint FK_T_FIN_FK_T_BAI foreign key (FIN_BAI_CODE)
  references T_BAILLEUR (BAI_CODE);
alter table T_FINANCEMENT
  add constraint FK_T_FIN_FK_T_DEV foreign key (FIN_DEV_CODE)
  references T_DEVISE (DEV_CODE);
alter table T_FINANCEMENT
  add constraint FK_T_FIN_FK_T_PRO foreign key (FIN_PRO_ID)
  references T_PROJET (PRO_ID);
alter table T_FINANCEMENT
  add constraint FK_T_FIN_FK_T_SOU foreign key (FIN_SOU_CODE)
  references T_SOURCE_FINANCEMENT (SOU_CODE);
create index FK_T_A_R_T_B_FK on T_FINANCEMENT (FIN_BAI_CODE);
create index FK_T_A_R_T_D_FK on T_FINANCEMENT (FIN_DEV_CODE);
create index FK_T_A_R_T_P_FK on T_FINANCEMENT (FIN_PRO_ID);
create index FK_T_A_R_T_S_FK on T_FINANCEMENT (FIN_SOU_CODE);

prompt
prompt Creating table T_AFFICHAGE_AGPM
prompt ===============================
prompt
create table T_AFFICHAGE_AGPM
(
  AFF_ID                NUMBER(10) not null,
  AFF_PRO_ID            NUMBER(10) not null,
  AFF_FIN_ID            NUMBER(10) not null,
  AFF_GES_CODE          NUMBER(4) not null,
  AFF_DEC_ID            NUMBER(10),
  AFF_AGP_STA_CODE      VARCHAR2(3) not null,
  AFF_AGP_ID            NUMBER(10) not null,
  AFF_BAI_CODE          VARCHAR2(5) not null,
  AFF_SOU_CODE          VARCHAR2(5) not null,
  AFF_DEV_CODE          VARCHAR2(8) not null,
  AFF_STR_CODE          VARCHAR2(3) not null,
  AFF_FON_COD           VARCHAR2(12) not null,
  AFF_AGP_ACTEUR_SAISIE VARCHAR2(12),
  AFF_AGP_STATUT_RETOUR VARCHAR2(2),
  AFF_AGP_ACTIF         VARCHAR2(1),
  AFF_AGP_TYPE_DAO      VARCHAR2(1000),
  AFF_AGP_COMMENTAIRE   VARCHAR2(1000)
)
;
alter table T_AFFICHAGE_AGPM
  add constraint T_AFFICHAGE_AGPM_PK primary key (AFF_ID);
alter table T_AFFICHAGE_AGPM
  add constraint FK_AFF_BAI_CODE foreign key (AFF_BAI_CODE)
  references T_BAILLEUR (BAI_CODE);
alter table T_AFFICHAGE_AGPM
  add constraint FK_AFF_DEC_ID foreign key (AFF_DEC_ID)
  references T_DECLARANT (DEC_ID);
alter table T_AFFICHAGE_AGPM
  add constraint FK_AFF_DEV_CODE foreign key (AFF_DEV_CODE)
  references T_DEVISE (DEV_CODE);
alter table T_AFFICHAGE_AGPM
  add constraint FK_AFF_FIN_ID foreign key (AFF_FIN_ID)
  references T_FINANCEMENT (FIN_ID);
alter table T_AFFICHAGE_AGPM
  add constraint FK_AFF_FON_CODE foreign key (AFF_FON_COD)
  references T_FONCTION (FON_COD);
alter table T_AFFICHAGE_AGPM
  add constraint FK_AFF_GES_CODE foreign key (AFF_GES_CODE)
  references T_GESTION (GES_CODE);
alter table T_AFFICHAGE_AGPM
  add constraint FK_AFF_PRO_ID foreign key (AFF_PRO_ID)
  references T_PROJET (PRO_ID);
alter table T_AFFICHAGE_AGPM
  add constraint FK_AFF_SOURCE_FIN foreign key (AFF_SOU_CODE)
  references T_SOURCE_FINANCEMENT (SOU_CODE);
alter table T_AFFICHAGE_AGPM
  add constraint FK_AFF_STA_CODE foreign key (AFF_AGP_STA_CODE)
  references T_STATUT (STA_CODE);
alter table T_AFFICHAGE_AGPM
  add constraint FK_AFF_STR_CODE foreign key (AFF_STR_CODE)
  references T_STRUCTURE (STR_CODE);

prompt
prompt Creating table T_NATURES
prompt ========================
prompt
create table T_NATURES
(
  NAT_LIBELLE    VARCHAR2(200),
  NAT_CODE       VARCHAR2(20) not null,
  NAT_UTIL_SAISI VARCHAR2(10),
  NAT_UTIL_MODIF VARCHAR2(10),
  NAT_DTE_SAISI  DATE,
  NAT_DTE_MODIF  DATE,
  NAT_C_CLASSE   VARCHAR2(1)
)
;
alter table T_NATURES
  add constraint NAT_PK primary key (NAT_CODE);

prompt
prompt Creating table T_DESTINATIONS
prompt =============================
prompt
create table T_DESTINATIONS
(
  DES_CODE       VARCHAR2(20) not null,
  DES_ADR        VARCHAR2(200),
  DES_LIB        VARCHAR2(200) not null,
  DES_UTIL_SAISI VARCHAR2(10),
  DES_UTIL_MODIF VARCHAR2(10),
  DES_DDTE_MODIF DATE,
  DES_DTE_SAISI  DATE,
  DES_REG_CODE   VARCHAR2(2)
)
;
alter table T_DESTINATIONS
  add constraint DES_PK primary key (DES_CODE);

prompt
prompt Creating table T_L_BUDGETS
prompt ==========================
prompt
create table T_L_BUDGETS
(
  LBG_CODE             VARCHAR2(50) not null,
  LBG_STR_CODE         VARCHAR2(10) not null,
  LBG_GES_CODE         NUMBER(4) not null,
  LBG_RES_DON          NUMBER(20) not null,
  LBG_IMPUTATION       VARCHAR2(20) not null,
  LBG_ANO_CODE         NUMBER(10),
  LBG_NAT_CODE         VARCHAR2(20) not null,
  LBG_RES_TR           NUMBER(20) not null,
  LBG_DTE_SAISI        DATE,
  LBG_AE_TR            NUMBER(20) not null,
  LBG_AE_DON           NUMBER(20) not null,
  LBG_AE_EMP           NUMBER(20) not null,
  LBG_MP               VARCHAR2(1) default 'N',
  LBG_REGL_MP          VARCHAR2(1) default 'N',
  LBG_TOT_DOT          NUMBER(20) not null,
  LBG_UTIL_SAISI       VARCHAR2(10),
  LBG_DES_CODE         VARCHAR2(10),
  LBG_DTE_MODIF        DATE,
  LBG_RES_EMP          NUMBER(20),
  LBG_RES_TOT          NUMBER(20),
  LBG_UTIL_MODIF       VARCHAR2(12),
  LBG_FON_CODE         VARCHAR2(12),
  LBG_DIS_TRE          NUMBER(20),
  LBG_DIS_DON          NUMBER(20),
  LBG_DIS_EMP          NUMBER(20),
  LBG_DIS_TOT          NUMBER(20),
  LBG_FON_CODE_AC      VARCHAR2(12),
  LBG_STA_CODE         VARCHAR2(3) default 'IC3',
  LBG_ACT_NUM_MODIF    VARCHAR2(100),
  LBG_DTE_VAL          DATE,
  LBG_FON_CODE_VAL     VARCHAR2(10),
  LBG_TRAITMT          VARCHAR2(1) default 'N',
  LBG_TRAITMT_NOTIF    VARCHAR2(1),
  LBG_DTE_STA_COUR     DATE,
  LBG_TITRE            VARCHAR2(20),
  LBG_COR              VARCHAR2(1),
  LBG_ADM_CENTRAL      VARCHAR2(1) not null,
  LBG_MOTIF_COR        VARCHAR2(200),
  LBG_DTE_COR          DATE,
  LBG_FON_CODE_COR     VARCHAR2(10),
  LBG_FON_CODE_PF      VARCHAR2(12),
  LBG_FON_CODE_VAL_ACT VARCHAR2(10),
  LBG_ACTIF            VARCHAR2(1) default 'O',
  LBG_FON_CODE_CF      VARCHAR2(20),
  LBG_DOT_AN_PLUS1     NUMBER(20),
  LBG_DOT_AN_PLUS2     NUMBER(20),
  LBG_DOT_AN_PLUS0     NUMBER(20),
  LBG_TYP_BUD          VARCHAR2(10),
  LBG_DTE_MP           DATE,
  LBG_UTIL_SAISI_ACT   VARCHAR2(10),
  LBG_SIGFIP           VARCHAR2(1),
  LBG_FON_CODE_PR      VARCHAR2(20),
  LBG_FON_CODE_VEROU   VARCHAR2(20)
)
;
alter table T_L_BUDGETS
  add constraint LBG_CODE_PK primary key (LBG_CODE);
alter table T_L_BUDGETS
  add constraint LBG_STR_GES_IMP_UK unique (LBG_STR_CODE, LBG_GES_CODE, LBG_IMPUTATION);
alter table T_L_BUDGETS
  add constraint LBG_DES_FK foreign key (LBG_DES_CODE)
  references T_DESTINATIONS (DES_CODE);
alter table T_L_BUDGETS
  add constraint LBG_FON_AC_FK foreign key (LBG_FON_CODE_AC)
  references T_FONCTION (FON_COD);
alter table T_L_BUDGETS
  add constraint LBG_FON_FK foreign key (LBG_FON_CODE)
  references T_FONCTION (FON_COD);
alter table T_L_BUDGETS
  add constraint LBG_GES_FK foreign key (LBG_GES_CODE)
  references T_GESTION (GES_CODE);
alter table T_L_BUDGETS
  add constraint LBG_NAT_FK foreign key (LBG_NAT_CODE)
  references T_NATURES (NAT_CODE);
alter table T_L_BUDGETS
  add constraint LBG_STR_FK foreign key (LBG_STR_CODE)
  references T_STRUCTURE (STR_CODE);
alter table T_L_BUDGETS
  add constraint LBG_DISPONIBLE_CK
  check (lbg_dis_tot >=0 and lbg_dis_tre >=0 and lbg_dis_emp >=0 and lbg_dis_don >=0)
  disable;
alter table T_L_BUDGETS
  add constraint LBG_RES_CK
  check (lbg_res_tot <= lbg_tot_dot and lbg_res_tr <= lbg_ae_tr and lbg_res_emp <= lbg_ae_emp  and lbg_res_don <= lbg_ae_don)
  disable;
alter table T_L_BUDGETS
  add constraint LBG_SUM_RES_CK
  check (lbg_res_tot =lbg_res_tr +  lbg_res_emp  +  lbg_res_don);
create index LBG_ANO_FK_I on T_L_BUDGETS (LBG_ANO_CODE);
create index LBG_DES_FK_I_1 on T_L_BUDGETS (LBG_DES_CODE);
create index LBG_GES_FK_I_1 on T_L_BUDGETS (LBG_GES_CODE);
create index LBG_NAT_FK_I_1 on T_L_BUDGETS (LBG_NAT_CODE);
create index LBG_STR_FK_I on T_L_BUDGETS (LBG_STR_CODE);

prompt
prompt Creating table T_OPERATEUR
prompt ==========================
prompt
create table T_OPERATEUR
(
  OPE_MATRICULE         VARCHAR2(25) not null,
  OPE_NOM               VARCHAR2(255),
  OPE_CONTACT           VARCHAR2(250),
  OPE_ETAT_CIVIL        VARCHAR2(250),
  OPE_MAIL              VARCHAR2(250),
  OPE_LOGIN             VARCHAR2(50),
  OPE_MIN_CODE          VARCHAR2(3),
  OPE_FONCTION_ADMINIST VARCHAR2(500),
  OPE_STR_CODE          VARCHAR2(3)
)
;
comment on column T_OPERATEUR.OPE_MIN_CODE
  is 'Code du Ministère de rattachement';
comment on column T_OPERATEUR.OPE_FONCTION_ADMINIST
  is 'Fonction Administrative';
alter table T_OPERATEUR
  add constraint PK_T_OPERATEUR primary key (OPE_MATRICULE);
alter table T_OPERATEUR
  add constraint FK_OPE_STR_CODE foreign key (OPE_STR_CODE)
  references T_STRUCTURE (STR_CODE);
alter table T_OPERATEUR
  add constraint FK_T_OPERATEUR foreign key (OPE_MIN_CODE)
  references T_MINISTERE (MIN_CODE);

prompt
prompt Creating table T_TYPE_MARCHE
prompt ============================
prompt
create table T_TYPE_MARCHE
(
  TYM_CODE          VARCHAR2(3) not null,
  TYM_LIBELLE_COURT VARCHAR2(500) not null,
  TYM_LIBELLE_LONG  VARCHAR2(1000),
  TYM_TYM_CODE      VARCHAR2(3),
  TYM_GROUPE        VARCHAR2(2)
)
;
comment on table T_TYPE_MARCHE
  is 'Liste des TYPE DE DAO (Travaux, Services, ...) ';
comment on column T_TYPE_MARCHE.TYM_CODE
  is 'Code du TYPE_DAO';
alter table T_TYPE_MARCHE
  add constraint TYM_PK primary key (TYM_CODE);

prompt
prompt Creating table T_MODELE_DAC_TYPE
prompt ================================
prompt
create table T_MODELE_DAC_TYPE
(
  MDT_CODE          VARCHAR2(15) not null,
  MDT_LIBELLE_LONG  VARCHAR2(500),
  MDT_LIBELLE_COURT VARCHAR2(500),
  MDT_DTE_SAISI     DATE,
  MDT_OPE_MATRICULE VARCHAR2(25),
  MDT_TYM_CODE      VARCHAR2(3)
)
;
comment on column T_MODELE_DAC_TYPE.MDT_CODE
  is 'Code du modèle type de DAC';
comment on column T_MODELE_DAC_TYPE.MDT_LIBELLE_LONG
  is 'Libellé du modèle type de DAC';
comment on column T_MODELE_DAC_TYPE.MDT_LIBELLE_COURT
  is 'Libelle court du modèle type de DAC';
comment on column T_MODELE_DAC_TYPE.MDT_DTE_SAISI
  is 'date de creation du modèle type de DAC';
comment on column T_MODELE_DAC_TYPE.MDT_OPE_MATRICULE
  is 'opérateur de la création  du modèle type de DAC';
comment on column T_MODELE_DAC_TYPE.MDT_TYM_CODE
  is 'Type marche  du modèle type de DAC';
alter table T_MODELE_DAC_TYPE
  add constraint MDT_CODE_PK primary key (MDT_CODE);
alter table T_MODELE_DAC_TYPE
  add constraint MDT_OPE_MATRICULE_FK foreign key (MDT_OPE_MATRICULE)
  references T_OPERATEUR (OPE_MATRICULE);
alter table T_MODELE_DAC_TYPE
  add constraint MDT_TYM_CODE_FK foreign key (MDT_TYM_CODE)
  references T_TYPE_MARCHE (TYM_CODE);

prompt
prompt Creating table T_MODE_PASSATION
prompt ===============================
prompt
create table T_MODE_PASSATION
(
  MOP_CODE          VARCHAR2(3) not null,
  MOP_LIBELLE_COURT VARCHAR2(500) not null,
  MOP_LIBELLE_LONG  VARCHAR2(1000)
)
;
comment on table T_MODE_PASSATION
  is 'Liste des TYPE DE DAO (Appel Offre Ouvert, Appel Offre Restreint, ...) ';
comment on column T_MODE_PASSATION.MOP_CODE
  is 'Code du MODE_PASSATION';
alter table T_MODE_PASSATION
  add constraint MOP_PK primary key (MOP_CODE);

prompt
prompt Creating table T_PLAN_PASSATION
prompt ===============================
prompt
create table T_PLAN_PASSATION
(
  PLP_ID       NUMBER(10) not null,
  PLP_STR_CODE VARCHAR2(3) not null,
  PLP_FON_COD  VARCHAR2(12) not null,
  PLP_GES_CODE NUMBER(4) not null,
  PLP_CODE     VARCHAR2(50),
  PLP_LIBELLE  VARCHAR2(1000)
)
;
comment on table T_PLAN_PASSATION
  is 'Liste des PLANS GENERAUX';
alter table T_PLAN_PASSATION
  add constraint PK_T_PLAN_PASSATION primary key (PLP_ID);
alter table T_PLAN_PASSATION
  add constraint FK_T_PLP_FK_T_FON foreign key (PLP_FON_COD)
  references T_FONCTION (FON_COD);
alter table T_PLAN_PASSATION
  add constraint FK_T_PLP_FK_T_GES foreign key (PLP_GES_CODE)
  references T_GESTION (GES_CODE);
alter table T_PLAN_PASSATION
  add constraint FK_T_PLP_FK_T_STR foreign key (PLP_STR_CODE)
  references T_STRUCTURE (STR_CODE);
create index FK_T_PP_R_T_F_FK on T_PLAN_PASSATION (PLP_FON_COD);
create index FK_T_PP_R_T_G_FK on T_PLAN_PASSATION (PLP_GES_CODE);
create index FK_T_PP_R_T_M_FK on T_PLAN_PASSATION (PLP_STR_CODE);

prompt
prompt Creating table T_TYPE_PROCEDURE
prompt ===============================
prompt
create table T_TYPE_PROCEDURE
(
  TYP_ID  VARCHAR2(5) not null,
  TYP_LIB VARCHAR2(1000)
)
;
alter table T_TYPE_PROCEDURE
  add constraint PK_T_TYPE_PROCEDURE primary key (TYP_ID);

prompt
prompt Creating table T_DAC_SPECS
prompt ==========================
prompt
create table T_DAC_SPECS
(
  DAC_CODE           VARCHAR2(20) not null,
  DAC_OBJET          VARCHAR2(1000),
  DAC_DTE_SAISI      DATE,
  DAC_STA_CODE       VARCHAR2(3),
  DAC_TYM_CODE       VARCHAR2(5),
  DAC_MOP_CODE       VARCHAR2(3),
  DAC_NBR_OUV        NUMBER,
  DAC_GES_CODE       NUMBER,
  DAC_FON_COD_AC     VARCHAR2(12),
  DAC_STR_CODE       VARCHAR2(3),
  DAC_FON_CODE_CPMP  VARCHAR2(12),
  DAC_DTE_VAL_CPMP   DATE,
  DAC_DTE_VAL_DMP    DATE,
  DAC_TD_CODE        VARCHAR2(3),
  DAC_DPP_ID         NUMBER(10),
  DAC_DATE_RECEPTION DATE,
  DAC_STATUT_RETOUR  VARCHAR2(2),
  DAC_MENTION        VARCHAR2(100)
)
;
comment on column T_DAC_SPECS.DAC_CODE
  is 'Code du DAO';
comment on column T_DAC_SPECS.DAC_OBJET
  is 'Objet du dossier d''appel à la concurrence';
comment on column T_DAC_SPECS.DAC_DTE_SAISI
  is 'date de saisi';
comment on column T_DAC_SPECS.DAC_STA_CODE
  is 'statut du dossier d''appel à la concurrence';
comment on column T_DAC_SPECS.DAC_TYM_CODE
  is 'type de marché du dossier d''appel à la concurrence';
comment on column T_DAC_SPECS.DAC_MOP_CODE
  is 'mode de passation du dossier d''appel à la concurrence';
comment on column T_DAC_SPECS.DAC_NBR_OUV
  is 'nombre d''ouverture dossier d''appel à la concurrence';
comment on column T_DAC_SPECS.DAC_GES_CODE
  is 'Gestion du dossier d''appel à la concurrence';
comment on column T_DAC_SPECS.DAC_FON_COD_AC
  is 'autourité du dossier d''appel à la concurrence';
comment on column T_DAC_SPECS.DAC_STR_CODE
  is 'structure du dossier d''appel à la concurrence';
comment on column T_DAC_SPECS.DAC_FON_CODE_CPMP
  is 'CPMP du du dossier d''appel à la concurrence';
comment on column T_DAC_SPECS.DAC_DTE_VAL_CPMP
  is 'date de validation de la CPMP';
comment on column T_DAC_SPECS.DAC_DTE_VAL_DMP
  is 'Date de validation de la DMP';
comment on column T_DAC_SPECS.DAC_TD_CODE
  is 'Type du dossier d''appel à la concurrence (DAO, AMI, PREQUALIF';
alter table T_DAC_SPECS
  add constraint DAC_CODE_PK primary key (DAC_CODE);
alter table T_DAC_SPECS
  add constraint DAC_FON_COD_AC_FK foreign key (DAC_FON_COD_AC)
  references T_FONCTION (FON_COD);
alter table T_DAC_SPECS
  add constraint DAC_FON_CODE_CPMP_FK foreign key (DAC_FON_CODE_CPMP)
  references T_FONCTION (FON_COD);
alter table T_DAC_SPECS
  add constraint DAC_GES_CODE_FK foreign key (DAC_GES_CODE)
  references T_GESTION (GES_CODE);
alter table T_DAC_SPECS
  add constraint DAC_MOP_CODE_FK foreign key (DAC_MOP_CODE)
  references T_MODE_PASSATION (MOP_CODE);
alter table T_DAC_SPECS
  add constraint DAC_TYM_CODE_FK foreign key (DAC_TYM_CODE)
  references T_TYPE_MARCHE (TYM_CODE);
alter table T_DAC_SPECS
  add constraint FK_DAC_DPP_ID foreign key (DAC_DPP_ID)
  references T_DETAIL_PLAN_PASSATION (DPP_ID);
alter table T_DAC_SPECS
  add constraint FK_DAC_STA_CODE foreign key (DAC_STA_CODE)
  references T_STATUT (STA_CODE);
alter table T_DAC_SPECS
  add constraint FK_DAC_STR_CODE foreign key (DAC_STR_CODE)
  references T_STRUCTURE (STR_CODE);
alter table T_DAC_SPECS
  add constraint FK_DAC_TD_CODE foreign key (DAC_TD_CODE)
  references T_TYPE_DAC_SPECS (TDC_CODE);

prompt
prompt Creating table T_DETAIL_PLAN_GENERAL
prompt ====================================
prompt
create table T_DETAIL_PLAN_GENERAL
(
  GPG_ID             NUMBER(10) not null,
  GPG_PLG_ID         NUMBER(10) not null,
  GPG_AGP_ID         NUMBER(10),
  GPG_TYPE_PLAN      VARCHAR2(3) not null,
  GPG_STA_CODE       VARCHAR2(3) not null,
  GPG_TYM_CODE       VARCHAR2(3) not null,
  GPG_MOP_CODE       VARCHAR2(3) not null,
  GPG_CODE           VARCHAR2(50),
  GPG_OBJET          VARCHAR2(1000),
  GPG_NUMERO_ORDRE   NUMBER(8),
  GPG_PARTIE_PME_PMI VARCHAR2(1),
  GPG_COMMENTAIRE    VARCHAR2(1000),
  GPG_SOURCE_FIN     VARCHAR2(1000),
  GPG_DATE_DAO       DATE,
  GPG_ACTEUR_SAISIE  VARCHAR2(12),
  GPG_STATUT_RETOUR  VARCHAR2(4),
  GPG_DATE_SAISIE    DATE,
  GPG_STR_CODE       VARCHAR2(3)
)
;
comment on table T_DETAIL_PLAN_GENERAL
  is 'Liste des OPERATION DU PLAN GENERAL';
alter table T_DETAIL_PLAN_GENERAL
  add constraint PK_T_DETAIL_PLAN_GENERAL primary key (GPG_ID);
alter table T_DETAIL_PLAN_GENERAL
  add constraint FK_T_GPG_FK_T_DAO foreign key (GPG_TYM_CODE)
  references T_TYPE_MARCHE (TYM_CODE);
alter table T_DETAIL_PLAN_GENERAL
  add constraint FK_T_GPG_FK_T_MOP foreign key (GPG_MOP_CODE)
  references T_MODE_PASSATION (MOP_CODE);
alter table T_DETAIL_PLAN_GENERAL
  add constraint FK_T_GPG_FK_T_PLG foreign key (GPG_PLG_ID)
  references T_PLAN_GENERAL (PLG_ID);
alter table T_DETAIL_PLAN_GENERAL
  add constraint FK_T_GPG_FK_T_STA foreign key (GPG_STA_CODE)
  references T_STATUT (STA_CODE);
create index FK_T_DP_R_T_A_FK on T_DETAIL_PLAN_GENERAL (GPG_AGP_ID);
create index FK_T_DP_R_T_D_FK on T_DETAIL_PLAN_GENERAL (GPG_TYM_CODE);
create index FK_T_DP_R_T_M_FK on T_DETAIL_PLAN_GENERAL (GPG_MOP_CODE);
create index FK_T_DP_R_T_S_FK on T_DETAIL_PLAN_GENERAL (GPG_STA_CODE);
create index FK_T_DP_R_T_T_FK on T_DETAIL_PLAN_GENERAL (GPG_PLG_ID);

prompt
prompt Creating table T_DETAIL_PLAN_PASSATION
prompt ======================================
prompt
create table T_DETAIL_PLAN_PASSATION
(
  DPP_ID                       NUMBER(10) not null,
  DPP_PLP_ID                   NUMBER(10) not null,
  DPP_GPG_ID                   NUMBER(10) not null,
  DPP_STA_CODE                 VARCHAR2(3) not null,
  DPP_TYM_CODE                 VARCHAR2(3) not null,
  DPP_MOP_CODE                 VARCHAR2(3) not null,
  DPP_LBG_CODE                 VARCHAR2(50),
  DPP_TYPE_PLAN                VARCHAR2(3) not null,
  DPP_CODE                     VARCHAR2(50),
  DPP_NUMERO_ORDRE             NUMBER(8),
  DPP_DATE                     DATE,
  DPP_OBJET                    VARCHAR2(1000),
  DPP_SOURCE_FIN               VARCHAR2(1000),
  DPP_DATE_DAO_TRANS           DATE,
  DPP_DATE_DAO_APPROB_DMP      DATE,
  DPP_DATE_DAO_APPROB_BAIL     DATE,
  DPP_DATE_AVIS_AO_PUBLICATION DATE,
  DPP_DATE_OUVERT_OT           DATE,
  DPP_DATE_OUVERT_OF           DATE,
  DPP_DATE_ELAB_RAPPORT        DATE,
  DPP_DATE_JUGEMENT_OFFRE      DATE,
  DPP_DATE_ATT_APPROB_DMP      DATE,
  DPP_DATE_ATT_APPRO_BAIL      DATE,
  DPP_DATE_NEGOCIATION         DATE,
  DPP_DATE_SIGNAT_ATTRIB       DATE,
  DPP_DATE_SIGNAT_AC           DATE,
  DPP_DATE_MARCHE_APPROB       DATE,
  DPP_DATE_EXEC_DEBUT          DATE,
  DPP_DATE_EXEC_FIN            DATE,
  DPP_ACTEUR_SAISIE            VARCHAR2(12),
  DPP_STR_CODE                 VARCHAR2(3),
  DPP_STATUT_RETOUR            VARCHAR2(4),
  DPP_DATE_SAISIE              DATE,
  DPP_STRUCTURE_CONDUC         VARCHAR2(500),
  DPP_STRUCTURE_BENEFI         VARCHAR2(500),
  DPP_PARTIE_PME_PMI           VARCHAR2(1),
  DPP_TYP_ID                   VARCHAR2(5),
  DPP_STATUT_DAO               VARCHAR2(2),
  DPP_PIECE_DAO                VARCHAR2(15),
  DPP_DAC_CODE                 VARCHAR2(20),
  DPP_INV_ENTRE                DATE,
  DPP_DATE_ATT_APPROB_CPMP     DATE,
  DPP_DATE_JUGEMENT_OFFRE_TEC  DATE
)
;
comment on table T_DETAIL_PLAN_PASSATION
  is 'Liste des OPERATION DU PLAN DE PASSATION';
comment on column T_DETAIL_PLAN_PASSATION.DPP_DATE_JUGEMENT_OFFRE_TEC
  is 'Jugement tecnhique';
alter table T_DETAIL_PLAN_PASSATION
  add constraint PK_T_DETAIL_PLAN_PASSATION primary key (DPP_ID);
alter table T_DETAIL_PLAN_PASSATION
  add constraint DPP_PIECE_DAO_FK foreign key (DPP_PIECE_DAO)
  references T_MODELE_DAC_TYPE (MDT_CODE);
alter table T_DETAIL_PLAN_PASSATION
  add constraint FK_DPP_DAC_CODE foreign key (DPP_DAC_CODE)
  references T_DAC_SPECS (DAC_CODE);
alter table T_DETAIL_PLAN_PASSATION
  add constraint FK_DPP_STR_CODE foreign key (DPP_STR_CODE)
  references T_STRUCTURE (STR_CODE);
alter table T_DETAIL_PLAN_PASSATION
  add constraint FK_DPP_TYC_ID_CODE foreign key (DPP_TYP_ID)
  references T_TYPE_PROCEDURE (TYP_ID);
alter table T_DETAIL_PLAN_PASSATION
  add constraint FK_T_DPP_FK_T_AGP foreign key (DPP_GPG_ID)
  references T_DETAIL_PLAN_GENERAL (GPG_ID);
alter table T_DETAIL_PLAN_PASSATION
  add constraint FK_T_DPP_FK_T_DAO foreign key (DPP_TYM_CODE)
  references T_TYPE_MARCHE (TYM_CODE);
alter table T_DETAIL_PLAN_PASSATION
  add constraint FK_T_DPP_FK_T_L_BUDGET foreign key (DPP_LBG_CODE)
  references T_L_BUDGETS (LBG_CODE);
alter table T_DETAIL_PLAN_PASSATION
  add constraint FK_T_DPP_FK_T_MOP foreign key (DPP_MOP_CODE)
  references T_MODE_PASSATION (MOP_CODE);
alter table T_DETAIL_PLAN_PASSATION
  add constraint FK_T_DPP_FK_T_PLG foreign key (DPP_PLP_ID)
  references T_PLAN_PASSATION (PLP_ID)
  disable;
alter table T_DETAIL_PLAN_PASSATION
  add constraint FK_T_DPP_FK_T_STA foreign key (DPP_STA_CODE)
  references T_STATUT (STA_CODE);
create index FK_T_DPP_R_T_D_FK on T_DETAIL_PLAN_PASSATION (DPP_TYM_CODE);
create index FK_T_DPP_R_T_L_FK on T_DETAIL_PLAN_PASSATION (DPP_LBG_CODE);
create index FK_T_DPP_R_T_M_FK on T_DETAIL_PLAN_PASSATION (DPP_MOP_CODE);
create index FK_T_DPP_R_T_PG_FK on T_DETAIL_PLAN_PASSATION (DPP_GPG_ID);
create index FK_T_DPP_R_T_PP_FK on T_DETAIL_PLAN_PASSATION (DPP_PLP_ID);
create index FK_T_DPP_R_T_S_FK on T_DETAIL_PLAN_PASSATION (DPP_STA_CODE);

prompt
prompt Creating table T_TYPE_DAC_SPECS
prompt ===============================
prompt
create table T_TYPE_DAC_SPECS
(
  TDC_CODE    VARCHAR2(3) not null,
  TDC_LIBELLE VARCHAR2(1000)
)
;
comment on column T_TYPE_DAC_SPECS.TDC_CODE
  is 'Code du type de dossier d''appel à concurrence ';
comment on column T_TYPE_DAC_SPECS.TDC_LIBELLE
  is 'Libelle du type de dossier d''appel à concurrence ';
alter table T_TYPE_DAC_SPECS
  add constraint TDC_CODE_PK primary key (TDC_CODE);

prompt
prompt Creating table T_PLAN_GENERAL
prompt =============================
prompt
create table T_PLAN_GENERAL
(
  PLG_ID       NUMBER(10) not null,
  PLG_STR_CODE VARCHAR2(3) not null,
  PLG_FON_COD  VARCHAR2(12) not null,
  PLG_GES_CODE NUMBER(4) not null,
  PLG_CODE     VARCHAR2(50),
  PLG_LIBELLE  VARCHAR2(1000)
)
;
comment on table T_PLAN_GENERAL
  is 'Liste des PLANS GENERAUX';
alter table T_PLAN_GENERAL
  add constraint PK_T_PLAN_GENERAL primary key (PLG_ID);
alter table T_PLAN_GENERAL
  add constraint FK_T_PLG_FK_T_FON foreign key (PLG_FON_COD)
  references T_FONCTION (FON_COD);
alter table T_PLAN_GENERAL
  add constraint FK_T_PLG_FK_T_GES foreign key (PLG_GES_CODE)
  references T_GESTION (GES_CODE);
alter table T_PLAN_GENERAL
  add constraint FK_T_PLG_FK_T_STR foreign key (PLG_STR_CODE)
  references T_STRUCTURE (STR_CODE);
create index FK_T_PL_R_T_F_FK on T_PLAN_GENERAL (PLG_FON_COD);
create index FK_T_PL_R_T_G_FK on T_PLAN_GENERAL (PLG_GES_CODE);
create index FK_T_PL_R_T_M_FK on T_PLAN_GENERAL (PLG_STR_CODE);

prompt
prompt Creating table T_TYPE_SEANCE
prompt ============================
prompt
create table T_TYPE_SEANCE
(
  TSE_CODE          VARCHAR2(3) not null,
  TSE_LIBELLE       VARCHAR2(500),
  TSE_DTE_SAISI     DATE,
  TSE_FON_CODE      VARCHAR2(12),
  TSE_OPE_MATRICULE VARCHAR2(25)
)
;
comment on column T_TYPE_SEANCE.TSE_CODE
  is 'Code du type séance';
comment on column T_TYPE_SEANCE.TSE_LIBELLE
  is 'Type séance libellé';
comment on column T_TYPE_SEANCE.TSE_DTE_SAISI
  is 'date de saisie';
comment on column T_TYPE_SEANCE.TSE_FON_CODE
  is 'Fonction de saisie';
alter table T_TYPE_SEANCE
  add constraint TSE_CODE_PK primary key (TSE_CODE);
alter table T_TYPE_SEANCE
  add constraint FK_TSE_OPE_MATRICULE foreign key (TSE_OPE_MATRICULE)
  references T_OPERATEUR (OPE_MATRICULE);

prompt
prompt Creating table T_SEANCES
prompt ========================
prompt
create table T_SEANCES
(
  SEA_NUM           NUMBER not null,
  SEA_LIBELLE       VARCHAR2(500),
  SEA_TSE_CODE      VARCHAR2(3),
  SEA_QUORUM        VARCHAR2(1),
  SEA_NBR_PLI       NUMBER,
  SEA_RES           VARCHAR2(1),
  SEA_STE_SAISI     DATE,
  SEA_FON_CODE      VARCHAR2(12),
  SEA_OPE_MATRICULE VARCHAR2(25)
)
;
comment on column T_SEANCES.SEA_NUM
  is 'Numéro de la séance';
comment on column T_SEANCES.SEA_LIBELLE
  is 'Libellé de la séance';
comment on column T_SEANCES.SEA_TSE_CODE
  is 'Type de séance';
comment on column T_SEANCES.SEA_QUORUM
  is 'Quorum de la séance';
comment on column T_SEANCES.SEA_NBR_PLI
  is 'numbre de pli de la séance';
comment on column T_SEANCES.SEA_RES
  is 'Séance res';
comment on column T_SEANCES.SEA_STE_SAISI
  is 'date de la séance';
comment on column T_SEANCES.SEA_FON_CODE
  is 'Fonction de la séance';
comment on column T_SEANCES.SEA_OPE_MATRICULE
  is 'Opérateur de saisie de la séance';
alter table T_SEANCES
  add constraint SEA_NUM_PK primary key (SEA_NUM);
alter table T_SEANCES
  add constraint SEA_FON_CODE_FK foreign key (SEA_FON_CODE)
  references T_FONCTION (FON_COD);
alter table T_SEANCES
  add constraint SEA_OPE_MATRICULE_FK foreign key (SEA_OPE_MATRICULE)
  references T_OPERATEUR (OPE_MATRICULE);
alter table T_SEANCES
  add constraint SEA_TSE_CODE_FK foreign key (SEA_TSE_CODE)
  references T_TYPE_SEANCE (TSE_CODE);

prompt
prompt Creating table T_TYPE_COMMISSION
prompt ================================
prompt
create table T_TYPE_COMMISSION
(
  TCO_CODE          VARCHAR2(3) not null,
  TCO_LIBELLE       VARCHAR2(500),
  TCO_DTE_SAISI     DATE,
  TCO_OPE_MATRICULE VARCHAR2(20)
)
;
comment on column T_TYPE_COMMISSION.TCO_CODE
  is 'Type Commission';
comment on column T_TYPE_COMMISSION.TCO_LIBELLE
  is 'Libelle du type Commission';
comment on column T_TYPE_COMMISSION.TCO_DTE_SAISI
  is 'date de saisie';
comment on column T_TYPE_COMMISSION.TCO_OPE_MATRICULE
  is 'Opérateur de la saisie';
alter table T_TYPE_COMMISSION
  add constraint TCO_CODE_PK primary key (TCO_CODE);
alter table T_TYPE_COMMISSION
  add constraint TCO_OPE_MATRICULE_FK foreign key (TCO_OPE_MATRICULE)
  references T_OPERATEUR (OPE_MATRICULE);

prompt
prompt Creating table T_AVIS_APPEL_OFFRE
prompt =================================
prompt
create table T_AVIS_APPEL_OFFRE
(
  AAO_CODE          VARCHAR2(20) not null,
  AAO_LIBELLE       VARCHAR2(1000),
  AAO_DAC_CODE      VARCHAR2(20),
  AAO_DTE_SAISI     DATE,
  AAO_STA_CODE      VARCHAR2(3),
  AAO_DTE_PUB       DATE,
  AAO_DTE_OUV_TEC   DATE,
  AAO_DTE_HEUR_OUV  DATE,
  AAO_DTE_OUV_FIN   DATE,
  AAO_NBR_LOT       NUMBER,
  AAO_NBR_OUV       NUMBER,
  AAO_DELAI_VAL     NUMBER,
  AAO_FON_COD_AC    VARCHAR2(12),
  AAO_FON_CODE_CPMP VARCHAR2(12),
  AAO_NAT_INT       VARCHAR2(1),
  AAO_TAUX          VARCHAR2(3),
  AAO_LIEU_EXE      VARCHAR2(200),
  AAO_NOM_RESP      VARCHAR2(200),
  AAO_INTER_PUB     VARCHAR2(1),
  AAO_CAUT_DEF_EXIG VARCHAR2(1),
  AAO_BOMP_PUB      VARCHAR2(1),
  AAO_VENTE_PAR_LOT VARCHAR2(1),
  AAO_AVIS_BAIL     VARCHAR2(1),
  AAO_MT_CAUT       NUMBER,
  AAO_MODE_PAIEMENT VARCHAR2(20),
  AAO_COUT_DAC      NUMBER,
  AAO_LIEU_RECEP    VARCHAR2(1000),
  AAO_DATE_RECEP    DATE,
  AAO_HEURE_RECEP   DATE,
  AAO_ADA_NUM       NUMBER
)
;
comment on column T_AVIS_APPEL_OFFRE.AAO_CODE
  is 'Code de l''avis d''appel d''offre';
comment on column T_AVIS_APPEL_OFFRE.AAO_LIBELLE
  is 'Objet de l''avis d''appel d''offre';
comment on column T_AVIS_APPEL_OFFRE.AAO_DAC_CODE
  is 'DAC de l''avis d''appel d''offre';
comment on column T_AVIS_APPEL_OFFRE.AAO_DTE_SAISI
  is 'date de saisi de l''avis d''appel d''offre';
comment on column T_AVIS_APPEL_OFFRE.AAO_STA_CODE
  is 'Statut de l''avis';
comment on column T_AVIS_APPEL_OFFRE.AAO_DTE_PUB
  is 'date de publication de l''avis';
comment on column T_AVIS_APPEL_OFFRE.AAO_DTE_OUV_TEC
  is 'date prévisionnelle de l''ouverture technique';
comment on column T_AVIS_APPEL_OFFRE.AAO_DTE_HEUR_OUV
  is 'heure d''ouverture';
comment on column T_AVIS_APPEL_OFFRE.AAO_DTE_OUV_FIN
  is 'Date prévisionnelle de l''ouverture financière';
comment on column T_AVIS_APPEL_OFFRE.AAO_NBR_LOT
  is 'Nombre de lots';
comment on column T_AVIS_APPEL_OFFRE.AAO_NBR_OUV
  is 'nombre d''ouverture';
comment on column T_AVIS_APPEL_OFFRE.AAO_DELAI_VAL
  is 'delai de validité de l''offre';
comment on column T_AVIS_APPEL_OFFRE.AAO_FON_COD_AC
  is 'Code de l''ac';
comment on column T_AVIS_APPEL_OFFRE.AAO_FON_CODE_CPMP
  is 'Code de la CPMP';
comment on column T_AVIS_APPEL_OFFRE.AAO_NAT_INT
  is 'Appel d''offre national ou international';
comment on column T_AVIS_APPEL_OFFRE.AAO_TAUX
  is 'Taux d''évaluation de l''appel d''offre';
comment on column T_AVIS_APPEL_OFFRE.AAO_LIEU_EXE
  is 'Lieu d''exécution';
comment on column T_AVIS_APPEL_OFFRE.AAO_NOM_RESP
  is 'Structure responsable de l''appel d''offre';
comment on column T_AVIS_APPEL_OFFRE.AAO_INTER_PUB
  is 'Appel d''offre à publier dans les canaux internationaux';
comment on column T_AVIS_APPEL_OFFRE.AAO_CAUT_DEF_EXIG
  is 'caution définitif exégée';
comment on column T_AVIS_APPEL_OFFRE.AAO_BOMP_PUB
  is 'publication dans le BOMP';
comment on column T_AVIS_APPEL_OFFRE.AAO_VENTE_PAR_LOT
  is 'Appel d''offre vendu par l''eau';
comment on column T_AVIS_APPEL_OFFRE.AAO_AVIS_BAIL
  is 'Appel d''offre avec avis du bailleur';
comment on column T_AVIS_APPEL_OFFRE.AAO_MT_CAUT
  is 'Montant du cautionnement';
comment on column T_AVIS_APPEL_OFFRE.AAO_MODE_PAIEMENT
  is 'Mode de paiement du dossier d''appel d''offres';
comment on column T_AVIS_APPEL_OFFRE.AAO_COUT_DAC
  is 'Cout du dossier d''appel à concurrence';
comment on column T_AVIS_APPEL_OFFRE.AAO_LIEU_RECEP
  is 'Lieu de recpetion des offres';
comment on column T_AVIS_APPEL_OFFRE.AAO_DATE_RECEP
  is 'Date de reception des offres';
comment on column T_AVIS_APPEL_OFFRE.AAO_HEURE_RECEP
  is 'Heure de reception des offres';
comment on column T_AVIS_APPEL_OFFRE.AAO_ADA_NUM
  is 'Adresse de l''avis';
alter table T_AVIS_APPEL_OFFRE
  add constraint AAO_CODE_PK primary key (AAO_CODE);
alter table T_AVIS_APPEL_OFFRE
  add constraint AAO_ADA_NUM_FK foreign key (AAO_ADA_NUM)
  references T_ADRESSE_AVIS (ADA_NUM);
alter table T_AVIS_APPEL_OFFRE
  add constraint AAO_DAC_CODE_FK foreign key (AAO_DAC_CODE)
  references T_DAC_SPECS (DAC_CODE);
alter table T_AVIS_APPEL_OFFRE
  add constraint AAO_FON_COD_AC_FK foreign key (AAO_FON_COD_AC)
  references T_FONCTION (FON_COD);
alter table T_AVIS_APPEL_OFFRE
  add constraint AAO_FON_CODE_CPMP_FK foreign key (AAO_FON_CODE_CPMP)
  references T_FONCTION (FON_COD);
alter table T_AVIS_APPEL_OFFRE
  add constraint AAO_STA_CODE_FK foreign key (AAO_STA_CODE)
  references T_STATUT (STA_CODE);

prompt
prompt Creating table T_COMMISSION_TYPE
prompt ================================
prompt
create table T_COMMISSION_TYPE
(
  TCT_CODE          VARCHAR2(3) not null,
  TCT_LIBELLE       VARCHAR2(500),
  TCT_TITRE         VARCHAR2(200),
  TCT_TST_CODE      VARCHAR2(3),
  TCT_TCO_CODE      VARCHAR2(3),
  TCT_DTE_SAISI     DATE,
  TCT_OPE_MATRICULE VARCHAR2(20),
  TCT_GRP_CODE      VARCHAR2(20)
)
;
comment on column T_COMMISSION_TYPE.TCT_CODE
  is 'Code de la commission type';
comment on column T_COMMISSION_TYPE.TCT_LIBELLE
  is 'libelle de la fonction du membre de la commission';
comment on column T_COMMISSION_TYPE.TCT_TITRE
  is 'titre du membre de la commission type (Président, Rapporteur, membre, etc..)';
comment on column T_COMMISSION_TYPE.TCT_TST_CODE
  is 'Code du type de structure (04 Collectivités, 02 etat, etc..)';
comment on column T_COMMISSION_TYPE.TCT_TCO_CODE
  is 'Code du type commission (COJO, Commission d''analyse ect...)';
comment on column T_COMMISSION_TYPE.TCT_DTE_SAISI
  is 'date de création ou de saisi';
comment on column T_COMMISSION_TYPE.TCT_OPE_MATRICULE
  is 'Opérateur de la saisi';
comment on column T_COMMISSION_TYPE.TCT_GRP_CODE
  is 'Regroupe de manière spécifique le Type_commission en fonction de la structure';
alter table T_COMMISSION_TYPE
  add constraint TCT_CODE_PK primary key (TCT_CODE);
alter table T_COMMISSION_TYPE
  add constraint TCT_OPE_MATRICULE_FK foreign key (TCT_OPE_MATRICULE)
  references T_OPERATEUR (OPE_MATRICULE);
alter table T_COMMISSION_TYPE
  add constraint TCT_TCO_CODE_FK foreign key (TCT_TCO_CODE)
  references T_TYPE_COMMISSION (TCO_CODE);
alter table T_COMMISSION_TYPE
  add constraint TCT_TST_CODE_FK foreign key (TCT_TST_CODE)
  references T_TYPE_STRUCTURE (TST_CODE);

prompt
prompt Creating table T_COMMISSION_SPECIFIQUE
prompt ======================================
prompt
create table T_COMMISSION_SPECIFIQUE
(
  COM_NUM           NUMBER not null,
  COM_DTE_SAISI     DATE,
  COM_STR_CODE      VARCHAR2(20),
  COM_TCT_CODE      VARCHAR2(3),
  COM_OPE_MATRICULE VARCHAR2(20),
  COM_DAC_CODE      VARCHAR2(20),
  COM_MAR_CODE      VARCHAR2(20),
  COM_AAO_CODE      VARCHAR2(20),
  COM_TCO_CODE      VARCHAR2(3)
)
;
comment on column T_COMMISSION_SPECIFIQUE.COM_NUM
  is 'Numéro de la commission spécifique';
comment on column T_COMMISSION_SPECIFIQUE.COM_DTE_SAISI
  is 'date de saisie de l''enregistrement';
comment on column T_COMMISSION_SPECIFIQUE.COM_STR_CODE
  is 'Code de la structure';
comment on column T_COMMISSION_SPECIFIQUE.COM_TCT_CODE
  is 'Code de la commission type';
comment on column T_COMMISSION_SPECIFIQUE.COM_OPE_MATRICULE
  is 'Code de l''opérateur de saisi';
comment on column T_COMMISSION_SPECIFIQUE.COM_DAC_CODE
  is 'COde du dossier d''appel à concurrence';
comment on column T_COMMISSION_SPECIFIQUE.COM_MAR_CODE
  is 'Code du marche';
comment on column T_COMMISSION_SPECIFIQUE.COM_AAO_CODE
  is 'Code de l''avis d''appel d''offre';
comment on column T_COMMISSION_SPECIFIQUE.COM_TCO_CODE
  is 'type de la commission';
alter table T_COMMISSION_SPECIFIQUE
  add constraint COM_NUM_ID_PK primary key (COM_NUM);
alter table T_COMMISSION_SPECIFIQUE
  add constraint COM_AAO_CODE_FK foreign key (COM_AAO_CODE)
  references T_AVIS_APPEL_OFFRE (AAO_CODE);
alter table T_COMMISSION_SPECIFIQUE
  add constraint COM_DAC_CODE_FK foreign key (COM_DAC_CODE)
  references T_DAC_SPECS (DAC_CODE);
alter table T_COMMISSION_SPECIFIQUE
  add constraint COM_STR_CODE_FK foreign key (COM_STR_CODE)
  references T_STRUCTURE (STR_CODE);
alter table T_COMMISSION_SPECIFIQUE
  add constraint COM_TCO_CODE_FK foreign key (COM_TCO_CODE)
  references T_TYPE_COMMISSION (TCO_CODE);
alter table T_COMMISSION_SPECIFIQUE
  add constraint COM_TCT_CODE_FK foreign key (COM_TCT_CODE)
  references T_COMMISSION_TYPE (TCT_CODE);

prompt
prompt Creating table T_DET_COMMISSION_SEANCE
prompt ======================================
prompt
create table T_DET_COMMISSION_SEANCE
(
  DCS_NUM           NUMBER not null,
  DCS_DAC_CODE      VARCHAR2(20),
  DCS_FON_COD       VARCHAR2(100),
  DCS_OPE_MATRICULE VARCHAR2(20),
  DCS_SEA_NUM       NUMBER,
  DCS_DTE_SAISI     DATE,
  DCS_FON_COD_SAISI VARCHAR2(12),
  DCS_OBSERVATION   VARCHAR2(200),
  DCS_COM_TCO_CODE  VARCHAR2(3),
  DCS_COM_NUM       NUMBER,
  DCS_NOM_MBM       VARCHAR2(100),
  DCS_PRE_MBM       VARCHAR2(200),
  DCS_TEL_MBM       VARCHAR2(50),
  DCS_PRESENT       VARCHAR2(1),
  DCS_COM_STR_CODE  VARCHAR2(20),
  DCS_OPE_MAT_SAISI VARCHAR2(20),
  DCS_MBM_RESPO     VARCHAR2(1)
)
;
comment on column T_DET_COMMISSION_SEANCE.DCS_NUM
  is 'numéro de la composition';
comment on column T_DET_COMMISSION_SEANCE.DCS_DAC_CODE
  is 'code de dossier d''appel à la concurrence';
comment on column T_DET_COMMISSION_SEANCE.DCS_FON_COD
  is 'fonction du membre de la commission';
comment on column T_DET_COMMISSION_SEANCE.DCS_OPE_MATRICULE
  is 'Matricule du mebre de la commission';
comment on column T_DET_COMMISSION_SEANCE.DCS_SEA_NUM
  is 'numero de la seance';
comment on column T_DET_COMMISSION_SEANCE.DCS_DTE_SAISI
  is 'date de saisie';
comment on column T_DET_COMMISSION_SEANCE.DCS_FON_COD_SAISI
  is 'fonction de saisi';
comment on column T_DET_COMMISSION_SEANCE.DCS_OBSERVATION
  is 'Observation';
comment on column T_DET_COMMISSION_SEANCE.DCS_COM_TCO_CODE
  is 'Type de commission';
comment on column T_DET_COMMISSION_SEANCE.DCS_COM_NUM
  is 'Numéro de la commision spécifique';
comment on column T_DET_COMMISSION_SEANCE.DCS_NOM_MBM
  is 'nom du membre de la commission';
comment on column T_DET_COMMISSION_SEANCE.DCS_PRE_MBM
  is 'Prénom du membre de la commission';
comment on column T_DET_COMMISSION_SEANCE.DCS_TEL_MBM
  is 'Téléphone du membre de la commission';
comment on column T_DET_COMMISSION_SEANCE.DCS_PRESENT
  is 'Présent ou absent (O Présent ; N Absent)';
comment on column T_DET_COMMISSION_SEANCE.DCS_COM_STR_CODE
  is 'Code de la structure';
comment on column T_DET_COMMISSION_SEANCE.DCS_OPE_MAT_SAISI
  is 'Opérateur de la saisi';
comment on column T_DET_COMMISSION_SEANCE.DCS_MBM_RESPO
  is 'Opérateur Responsable OUI/NON';
alter table T_DET_COMMISSION_SEANCE
  add constraint DCS_NUM_PK primary key (DCS_NUM);
alter table T_DET_COMMISSION_SEANCE
  add constraint DCS_COM_NUM_FK foreign key (DCS_COM_NUM)
  references T_COMMISSION_SPECIFIQUE (COM_NUM);
alter table T_DET_COMMISSION_SEANCE
  add constraint DCS_COM_STR_CODE_FK foreign key (DCS_COM_STR_CODE)
  references T_STRUCTURE (STR_CODE);
alter table T_DET_COMMISSION_SEANCE
  add constraint DCS_COM_TCO_CODE_FK foreign key (DCS_COM_TCO_CODE)
  references T_TYPE_COMMISSION (TCO_CODE);
alter table T_DET_COMMISSION_SEANCE
  add constraint DCS_DAC_CODE_FK foreign key (DCS_DAC_CODE)
  references T_DAC_SPECS (DAC_CODE);
alter table T_DET_COMMISSION_SEANCE
  add constraint DCS_OPE_MAT_SAISI_FK foreign key (DCS_OPE_MAT_SAISI)
  references T_OPERATEUR (OPE_MATRICULE);
alter table T_DET_COMMISSION_SEANCE
  add constraint DCS_SEA_NUM_FK foreign key (DCS_SEA_NUM)
  references T_SEANCES (SEA_NUM);

prompt
prompt Creating table T_AFFICHAGE_DAO
prompt ==============================
prompt
create table T_AFFICHAGE_DAO
(
  AFF_DAO_ID        NUMBER(10) not null,
  AFF_DCS_NUM       NUMBER not null,
  AFF_DAC_CODE      VARCHAR2(20) not null,
  AFF_OPE_MATRICULE VARCHAR2(25),
  AFF_STA_CODE      VARCHAR2(3),
  AFF_STATUT_RETOUR VARCHAR2(4)
)
;
alter table T_AFFICHAGE_DAO
  add constraint T_AFFICHAGE_DAO_PK primary key (AFF_DAO_ID);
alter table T_AFFICHAGE_DAO
  add constraint AFF_DAC_CODE_FK foreign key (AFF_DAC_CODE)
  references T_DAC_SPECS (DAC_CODE);
alter table T_AFFICHAGE_DAO
  add constraint AFF_DCS_NUM_FK foreign key (AFF_DCS_NUM)
  references T_DET_COMMISSION_SEANCE (DCS_NUM);

prompt
prompt Creating table T_AFFICHAGE_PGPM
prompt ===============================
prompt
create table T_AFFICHAGE_PGPM
(
  AFF_GPG_ID             NUMBER(10),
  AFF_GPG_PLG_ID         NUMBER(10) not null,
  AFF_GPG_AGP_ID         NUMBER(10),
  AFF_GPG_TYPE_PLAN      VARCHAR2(3) not null,
  AFF_GPG_STA_CODE       VARCHAR2(3) not null,
  AFF_GPG_TYM_CODE       VARCHAR2(3) not null,
  AFF_GPG_MOP_CODE       VARCHAR2(3) not null,
  AFF_GPG_CODE           VARCHAR2(50),
  AFF_GPG_OBJET          VARCHAR2(1000),
  AFF_GPG_NUMERO_ORDRE   NUMBER(8),
  AFF_GPG_PARTIE_PME_PMI VARCHAR2(1),
  AFF_GPG_COMMENTAIRE    VARCHAR2(1000),
  AFF_GPG_SOURCE_FIN     VARCHAR2(5),
  AFF_GPG_DATE_DAO       DATE,
  AFF_GPG_ACTEUR_SAISIE  VARCHAR2(12),
  AFF_GPG_STATUT_RETOUR  VARCHAR2(4),
  AFF_GPG_DATE_SAISIE    DATE,
  AFF_GPG_FON_COD        VARCHAR2(12),
  AFF_ID                 NUMBER(10) not null,
  AFF_GPG_STR_CODE       VARCHAR2(3),
  AFF_GPG_GES_CODE       NUMBER(4)
)
;
alter table T_AFFICHAGE_PGPM
  add constraint T_AFFICHAGE_PGPM_PK primary key (AFF_ID);
alter table T_AFFICHAGE_PGPM
  add constraint FK_AFF_GPG_GES_CODE foreign key (AFF_GPG_GES_CODE)
  references T_GESTION (GES_CODE);
alter table T_AFFICHAGE_PGPM
  add constraint FK_T_AFF_FK_T_DAO foreign key (AFF_GPG_TYM_CODE)
  references T_TYPE_MARCHE (TYM_CODE);
alter table T_AFFICHAGE_PGPM
  add constraint FK_T_AFF_FK_T_FON foreign key (AFF_GPG_FON_COD)
  references T_FONCTION (FON_COD);
alter table T_AFFICHAGE_PGPM
  add constraint FK_T_AFF_FK_T_MOP foreign key (AFF_GPG_MOP_CODE)
  references T_MODE_PASSATION (MOP_CODE);
alter table T_AFFICHAGE_PGPM
  add constraint FK_T_AFF_FK_T_PLG foreign key (AFF_GPG_PLG_ID)
  references T_PLAN_GENERAL (PLG_ID);
alter table T_AFFICHAGE_PGPM
  add constraint FK_T_AFF_FK_T_SOURCE foreign key (AFF_GPG_SOURCE_FIN)
  references T_SOURCE_FINANCEMENT (SOU_CODE);
alter table T_AFFICHAGE_PGPM
  add constraint FK_T_AFF_FK_T_STA foreign key (AFF_GPG_STA_CODE)
  references T_STATUT (STA_CODE);
alter table T_AFFICHAGE_PGPM
  add constraint FK_T_AFF_FK_T_STR foreign key (AFF_GPG_STR_CODE)
  references T_STRUCTURE (STR_CODE);

prompt
prompt Creating table T_AFFICHAGE_PPM
prompt ==============================
prompt
create table T_AFFICHAGE_PPM
(
  AFF_ID                        NUMBER(10) not null,
  AFF_DPP_PLP_ID                NUMBER(10) not null,
  AFF_DPP_GPG_ID                NUMBER(10) not null,
  AFF_DPP_STA_CODE              VARCHAR2(3) not null,
  AFF_DPP_TYM_CODE              VARCHAR2(3) not null,
  AFF_DPP_MOP_CODE              VARCHAR2(3) not null,
  AFF_DPP_LBG_CODE              VARCHAR2(50) not null,
  AFF_DPP_TYPE_PLAN             VARCHAR2(3) not null,
  AFF_DPP_CODE                  VARCHAR2(50),
  AFF_DPP_NUMERO_ORDRE          NUMBER(8),
  AFF_DPP_DATE                  DATE,
  AFF_DPP_OBJET                 VARCHAR2(1000),
  AFF_DPP_SOURCE_FIN            VARCHAR2(1000),
  AFF_DPP_ACTEUR_SAISIE         VARCHAR2(12),
  AFF_DPP_DATE_DAO_TRANS        DATE,
  AFF_DPP_DATE_DAO_APPROB_DMP   DATE,
  AFF_DPP_DATE_DAO_APPROB_BAIL  DATE,
  AFF_DPP_DATE_AVIS_AO_PUBLICAT DATE,
  AFF_DPP_DATE_OUVERT_OT        DATE,
  AFF_DPP_DATE_OUVERT_OF        DATE,
  AFF_DPP_DATE_ELAB_RAPPORT     DATE,
  AFF_DPP_DATE_JUGEMENT_OFFRE   DATE,
  AFF_DPP_DATE_ATT_APPROB_DMP   DATE,
  AFF_DPP_DATE_ATT_APPRO_BAIL   DATE,
  AFF_DPP_DATE_NEGOCIATION      DATE,
  AFF_DPP_DATE_SIGNAT_ATTRIB    DATE,
  AFF_DPP_DATE_SIGNAT_AC        DATE,
  AFF_DPP_DATE_MARCHE_APPROB    DATE,
  AFF_DPP_DATE_EXEC_DEBUT       DATE,
  AFF_DPP_DATE_EXEC_FIN         DATE,
  AFF_DPP_ID                    NUMBER(10),
  AFF_DPP_STATUT_RETOUR         VARCHAR2(10),
  AFF_DPP_FON_COD               VARCHAR2(12),
  AFF_DPP_STR_CODE              VARCHAR2(3),
  AFF_DPP_STR_CONDUC            VARCHAR2(1000),
  AFF_DPP_STR_BENEFI            VARCHAR2(1000),
  AFF_DPP_DATE_SAISIE           DATE,
  AFF_TYP_ID                    VARCHAR2(5),
  AFF_DPP_PARTIE_PME_PMI        VARCHAR2(1),
  AFF_DPP_STATUT_DAO            VARCHAR2(2),
  AFF_DPP_PIECE_DAO             VARCHAR2(15),
  AFF_DPP_INV_ENTRE             DATE
)
;
alter table T_AFFICHAGE_PPM
  add constraint PK_T_AFFICHAGE_PPM primary key (AFF_ID);
alter table T_AFFICHAGE_PPM
  add constraint FK_AFF_DPP_FON_COD foreign key (AFF_DPP_FON_COD)
  references T_FONCTION (FON_COD);
alter table T_AFFICHAGE_PPM
  add constraint FK_AFF_TYC_ID foreign key (AFF_TYP_ID)
  references T_TYPE_PROCEDURE (TYP_ID);
alter table T_AFFICHAGE_PPM
  add constraint FK_T_AFDPP_FK_T_AGP foreign key (AFF_DPP_GPG_ID)
  references T_DETAIL_PLAN_GENERAL (GPG_ID);
alter table T_AFFICHAGE_PPM
  add constraint FK_T_AFDPP_FK_T_DAO foreign key (AFF_DPP_TYM_CODE)
  references T_TYPE_MARCHE (TYM_CODE);
alter table T_AFFICHAGE_PPM
  add constraint FK_T_AFDPP_FK_T_MOP foreign key (AFF_DPP_MOP_CODE)
  references T_MODE_PASSATION (MOP_CODE);
alter table T_AFFICHAGE_PPM
  add constraint FK_T_AFDPP_FK_T_PLG foreign key (AFF_DPP_PLP_ID)
  references T_PLAN_PASSATION (PLP_ID)
  disable;
alter table T_AFFICHAGE_PPM
  add constraint FK_T_AFDPP_FK_T_STA foreign key (AFF_DPP_STA_CODE)
  references T_STATUT (STA_CODE);
alter table T_AFFICHAGE_PPM
  add constraint FK_T_AFDPP_FK_T_STR foreign key (AFF_DPP_STR_CODE)
  references T_STRUCTURE (STR_CODE);
alter table T_AFFICHAGE_PPM
  add constraint FK_TAFF_LBG_CODE foreign key (AFF_DPP_LBG_CODE)
  references T_L_BUDGETS (LBG_CODE);

prompt
prompt Creating table T_ASSIGNATION
prompt ============================
prompt
create table T_ASSIGNATION
(
  ASS_NUM           NUMBER(10) not null,
  ASS_FON_COD       VARCHAR2(12),
  ASS_OPE_MATRICULE VARCHAR2(25),
  ASS_DAT_DEB       DATE,
  ASS_DAT_FIN       DATE,
  ASS_COURANT       VARCHAR2(10) default 'N',
  ASS_STATUT        NUMBER(1)
)
;
comment on column T_ASSIGNATION.ASS_STATUT
  is '1 ou 0';
alter table T_ASSIGNATION
  add constraint PK_T_ASSIGNATION primary key (ASS_NUM);
alter table T_ASSIGNATION
  add constraint FK_T_ASS_FK_T_FON foreign key (ASS_FON_COD)
  references T_FONCTION (FON_COD);
alter table T_ASSIGNATION
  add constraint FK_T_ASS_FK_T_OPE foreign key (ASS_OPE_MATRICULE)
  references T_OPERATEUR (OPE_MATRICULE);
create index FK_T_A_R_T_F_FK on T_ASSIGNATION (ASS_FON_COD);
create index FK_T_A_R_T_O_FK on T_ASSIGNATION (ASS_OPE_MATRICULE);

prompt
prompt Creating table T_BESOIN
prompt =======================
prompt
create table T_BESOIN
(
  BES_ID      NUMBER(10) not null,
  BES_REG_ID  NUMBER(10) not null,
  BES_PRO_ID  NUMBER(5) not null,
  BES_LIBELLE VARCHAR2(1000),
  BES_STATUT  VARCHAR2(1) default 'O'
)
;
comment on column T_BESOIN.BES_STATUT
  is 'O ou N';
alter table T_BESOIN
  add constraint PK_T_BESOIN primary key (BES_ID);
alter table T_BESOIN
  add constraint FK_T_BES_FK_T_PRO foreign key (BES_PRO_ID)
  references T_PROJET (PRO_ID);
alter table T_BESOIN
  add constraint FK_T_BES_FK_T_REG foreign key (BES_REG_ID)
  references T_REGLEMENTATION (REG_ID);
create index FK_T_B_R_T_P_FK on T_BESOIN (BES_PRO_ID);
create index FK_T_B_R_T_R_FK on T_BESOIN (BES_REG_ID);

prompt
prompt Creating table T_TYPE_CHARGE
prompt ============================
prompt
create table T_TYPE_CHARGE
(
  TYC_CODE          VARCHAR2(3) not null,
  TYC_LIBELLE_COURT VARCHAR2(500) not null,
  TYC_LIBELLE_LONG  VARCHAR2(1000),
  TYM_TYM_CODE      VARCHAR2(3),
  TYM_GROUPE        VARCHAR2(3)
)
;
comment on table T_TYPE_CHARGE
  is 'Liste des TYPE DE DAO (Execution, Passation, Description des bésoins, ...) ';
comment on column T_TYPE_CHARGE.TYC_CODE
  is 'Code du TYPE_CHARGE';
alter table T_TYPE_CHARGE
  add constraint TYC_PK primary key (TYC_CODE);

prompt
prompt Creating table T_CHARGE
prompt =======================
prompt
create table T_CHARGE
(
  CHR_ID          NUMBER(10) not null,
  CHR_STR_CODE    VARCHAR2(3) not null,
  CHR_TYC_CODE    VARCHAR2(3) not null,
  CHR_DPP_ID      NUMBER(10) not null,
  CHR_COMMENTAIRE VARCHAR2(1000),
  CHR_STATUT      VARCHAR2(1) default 'O'
)
;
comment on column T_CHARGE.CHR_STATUT
  is 'O ou N';
alter table T_CHARGE
  add constraint PK_T_CHARGE primary key (CHR_ID);
alter table T_CHARGE
  add constraint FK_T_CHR_FK_T_DPP foreign key (CHR_DPP_ID)
  references T_DETAIL_PLAN_PASSATION (DPP_ID);
alter table T_CHARGE
  add constraint FK_T_CHR_FK_T_STR foreign key (CHR_STR_CODE)
  references T_STRUCTURE (STR_CODE);
alter table T_CHARGE
  add constraint FK_T_CHR_FK_T_TYC foreign key (CHR_TYC_CODE)
  references T_TYPE_CHARGE (TYC_CODE);
create index FK_T_CH_T_P_FK on T_CHARGE (CHR_DPP_ID);
create index FK_T_CH_T_S_FK on T_CHARGE (CHR_STR_CODE);
create index FK_T_CH_T_T_FK on T_CHARGE (CHR_TYC_CODE);

prompt
prompt Creating table T_COMPOSANTE
prompt ===========================
prompt
create table T_COMPOSANTE
(
  COM_ID            NUMBER(10) not null,
  COM_PRO_ID        NUMBER(10),
  COM_CODE          VARCHAR2(50),
  COM_LIBELLE_COURT VARCHAR2(500) not null,
  COM_LIBELLE_LONG  VARCHAR2(1000)
)
;
comment on table T_COMPOSANTE
  is 'Liste des COMPOSANTES';
comment on column T_COMPOSANTE.COM_ID
  is 'ID de la COMPOSANTE';
comment on column T_COMPOSANTE.COM_CODE
  is 'Code du COMPOSANTE de la COMPOSANTE après sa validation';
alter table T_COMPOSANTE
  add constraint COM_PK primary key (COM_ID);
alter table T_COMPOSANTE
  add constraint FK_T_COM_FK_T_PRO foreign key (COM_PRO_ID)
  references T_PROJET (PRO_ID);
create index FK_T_P_T_C_FK on T_COMPOSANTE (COM_PRO_ID);

prompt
prompt Creating table T_CONTENU_AGPM
prompt =============================
prompt
create table T_CONTENU_AGPM
(
  TCA_CODE    VARCHAR2(4) not null,
  TCA_LIBELLE VARCHAR2(200)
)
;
alter table T_CONTENU_AGPM
  add constraint T_CONTENU_AGPM_PK primary key (TCA_CODE);

prompt
prompt Creating table T_CORRECTION_DAC
prompt ===============================
prompt
create table T_CORRECTION_DAC
(
  COR_NUM           NUMBER not null,
  COR_DAC_CODE      VARCHAR2(20),
  COR_LIEBLLE       VARCHAR2(200),
  COR_DTE_SAISI     DATE,
  COR_OPE_MATRICULE VARCHAR2(25)
)
;
comment on column T_CORRECTION_DAC.COR_NUM
  is 'Numero de la correction';
comment on column T_CORRECTION_DAC.COR_DAC_CODE
  is 'Code d_dossier d''appel à la concurrence';
comment on column T_CORRECTION_DAC.COR_LIEBLLE
  is 'Libellé de la correction';
comment on column T_CORRECTION_DAC.COR_DTE_SAISI
  is 'Date de saisie';
alter table T_CORRECTION_DAC
  add constraint COR_NUM_PK primary key (COR_NUM);
alter table T_CORRECTION_DAC
  add constraint COR_DAC_CODE_FK foreign key (COR_DAC_CODE)
  references T_DAC_SPECS (DAC_CODE);

prompt
prompt Creating table T_LIBELLE_ADRESSE
prompt ================================
prompt
create table T_LIBELLE_ADRESSE
(
  LIA_NUM     NUMBER(3) not null,
  LIA_LIBELLE VARCHAR2(500)
)
;
comment on column T_LIBELLE_ADRESSE.LIA_NUM
  is 'Numéro du libellé';
comment on column T_LIBELLE_ADRESSE.LIA_LIBELLE
  is 'libelle du detail adresse';
alter table T_LIBELLE_ADRESSE
  add constraint LIA_NUM_PK primary key (LIA_NUM);

prompt
prompt Creating table T_DETAIL_ADRESSE_AVIS
prompt ====================================
prompt
create table T_DETAIL_ADRESSE_AVIS
(
  DTA_NUM       NUMBER not null,
  DTA_ADA_NUM   NUMBER,
  DTA_TITRE     VARCHAR2(200),
  DTA_LIBELLE   VARCHAR2(500),
  DTA_DTE_SAISI DATE,
  DTA_LIA_NUM   NUMBER(3)
)
;
comment on column T_DETAIL_ADRESSE_AVIS.DTA_NUM
  is 'Numéro du détail adresse';
comment on column T_DETAIL_ADRESSE_AVIS.DTA_ADA_NUM
  is 'numéro du detail  l''adresse';
comment on column T_DETAIL_ADRESSE_AVIS.DTA_TITRE
  is 'Titre du détail adresse';
comment on column T_DETAIL_ADRESSE_AVIS.DTA_LIBELLE
  is 'libelle du detail adresse';
comment on column T_DETAIL_ADRESSE_AVIS.DTA_DTE_SAISI
  is 'date de saisie';
comment on column T_DETAIL_ADRESSE_AVIS.DTA_LIA_NUM
  is 'Code du libellé adresse';
alter table T_DETAIL_ADRESSE_AVIS
  add constraint DTA_NUM_PK primary key (DTA_NUM);
alter table T_DETAIL_ADRESSE_AVIS
  add constraint DTA_ADA_NUM_FK foreign key (DTA_ADA_NUM)
  references T_ADRESSE_AVIS (ADA_NUM);
alter table T_DETAIL_ADRESSE_AVIS
  add constraint DTA_LIA_NUM_FK foreign key (DTA_LIA_NUM)
  references T_LIBELLE_ADRESSE (LIA_NUM);

prompt
prompt Creating table T_DETAIL_AGPM
prompt ============================
prompt
create table T_DETAIL_AGPM
(
  TDA_ID          NUMBER not null,
  TDA_AGP_ID      NUMBER(10) not null,
  TDA_COMMENTAIRE VARCHAR2(4000),
  TDA_TCA_CODE    VARCHAR2(4),
  TDA_NUM_ORDRE   VARCHAR2(3),
  TDA_TITRE       VARCHAR2(100)
)
;
alter table T_DETAIL_AGPM
  add constraint T_DETAIL_AGPM_PK primary key (TDA_ID);
alter table T_DETAIL_AGPM
  add constraint FK_TDA_AGP_ID foreign key (TDA_AGP_ID)
  references T_AGPM (AGP_ID);
alter table T_DETAIL_AGPM
  add constraint FK_TDA_TCA_CODE foreign key (TDA_TCA_CODE)
  references T_CONTENU_AGPM (TCA_CODE);

prompt
prompt Creating table T_DETAIL_AVIS
prompt ============================
prompt
create table T_DETAIL_AVIS
(
  DAV_CODE      NUMBER not null,
  DAV_NUM_ORD   NUMBER,
  DAV_TITRE     VARCHAR2(200),
  DAV_CONTENU   VARCHAR2(2000),
  DAV_DTE_SAISI DATE,
  DAV_STA_CODE  VARCHAR2(3),
  DAV_AAO_CODE  VARCHAR2(20),
  DAV_DAC_CODE  VARCHAR2(20),
  DAV_AUTRE     VARCHAR2(200)
)
;
comment on column T_DETAIL_AVIS.DAV_CODE
  is 'Code du détail avis';
comment on column T_DETAIL_AVIS.DAV_NUM_ORD
  is 'Numéro d''ordre';
comment on column T_DETAIL_AVIS.DAV_TITRE
  is 'Titre du détail';
comment on column T_DETAIL_AVIS.DAV_CONTENU
  is 'Contenu du detail';
comment on column T_DETAIL_AVIS.DAV_DTE_SAISI
  is 'date de saisi du detail';
comment on column T_DETAIL_AVIS.DAV_STA_CODE
  is 'Statut';
comment on column T_DETAIL_AVIS.DAV_AAO_CODE
  is 'Code de l''avis';
comment on column T_DETAIL_AVIS.DAV_DAC_CODE
  is 'Code du dossier d''appel à la concurrence';
comment on column T_DETAIL_AVIS.DAV_AUTRE
  is 'Autres ';
alter table T_DETAIL_AVIS
  add constraint DAV_CODE_PK primary key (DAV_CODE);
alter table T_DETAIL_AVIS
  add constraint DAV_AAO_CODE_FK foreign key (DAV_AAO_CODE)
  references T_AVIS_APPEL_OFFRE (AAO_CODE);
alter table T_DETAIL_AVIS
  add constraint DAV_DAC_CODE foreign key (DAV_DAC_CODE)
  references T_DAC_SPECS (DAC_CODE);

prompt
prompt Creating table T_TYPE_PIECES_DAC
prompt ================================
prompt
create table T_TYPE_PIECES_DAC
(
  TPI_CODE     VARCHAR2(10) not null,
  TPI_LIBELLE  VARCHAR2(1000),
  TPI_DAC_PEC  VARCHAR2(15),
  TPI_MDT_CODE VARCHAR2(10),
  TPI_SEC_NUM  VARCHAR2(5)
)
;
comment on column T_TYPE_PIECES_DAC.TPI_CODE
  is 'Code du type de piece ';
comment on column T_TYPE_PIECES_DAC.TPI_LIBELLE
  is 'Libellé du Type de piece';
comment on column T_TYPE_PIECES_DAC.TPI_DAC_PEC
  is 'Type du dossier (DAC Type Travaux, DAC type fourniture, etc... En fonction des dossiers type d''appel à concurrence)';
comment on column T_TYPE_PIECES_DAC.TPI_MDT_CODE
  is 'Code du modèle type de DAC';
comment on column T_TYPE_PIECES_DAC.TPI_SEC_NUM
  is 'Section du du type de piece ';
alter table T_TYPE_PIECES_DAC
  add constraint TPI_CODE_FK primary key (TPI_CODE);
alter table T_TYPE_PIECES_DAC
  add constraint TPI_MDT_CODE_FK foreign key (TPI_MDT_CODE)
  references T_MODELE_DAC_TYPE (MDT_CODE);

prompt
prompt Creating table T_PIECES_DACS
prompt ============================
prompt
create table T_PIECES_DACS
(
  PID_CODE      NUMBER not null,
  PID_LIBELLE   VARCHAR2(1000),
  PID_TPI_CODE  VARCHAR2(10),
  PID_STA_CODE  VARCHAR2(3),
  PID_DTE_SAISI DATE,
  PID_DAC_CODE  VARCHAR2(20)
)
;
comment on column T_PIECES_DACS.PID_CODE
  is 'Code de la pièce';
comment on column T_PIECES_DACS.PID_LIBELLE
  is 'Libelle de la pièce';
comment on column T_PIECES_DACS.PID_TPI_CODE
  is 'Code du type de la pièce';
comment on column T_PIECES_DACS.PID_STA_CODE
  is 'statut de la pièce';
comment on column T_PIECES_DACS.PID_DTE_SAISI
  is 'date de saisie de la pièce';
comment on column T_PIECES_DACS.PID_DAC_CODE
  is 'Code du dossier du DAO';
alter table T_PIECES_DACS
  add constraint PID_CODE_PK primary key (PID_CODE);
alter table T_PIECES_DACS
  add constraint FK_PID_DAC_CODE foreign key (PID_DAC_CODE)
  references T_DAC_SPECS (DAC_CODE);
alter table T_PIECES_DACS
  add constraint PID_TPI_CODE_FK foreign key (PID_TPI_CODE)
  references T_TYPE_PIECES_DAC (TPI_CODE);

prompt
prompt Creating table T_DETAIL_CORRECTION
prompt ==================================
prompt
create table T_DETAIL_CORRECTION
(
  DCO_NUM           NUMBER not null,
  DCO_TITRE         VARCHAR2(200),
  DCO_LIBELLE       VARCHAR2(1000),
  DCO_DTE_SAISI     DATE,
  DCO_PID_CODE      NUMBER,
  DCO_DAC_CODE      VARCHAR2(20),
  DCO_FON_COD_SAISI VARCHAR2(12),
  DCO_OPE_MATRICULE VARCHAR2(25),
  DCO_OBSERVATION   VARCHAR2(1000),
  DCO_COR_NUM       NUMBER
)
;
comment on column T_DETAIL_CORRECTION.DCO_NUM
  is 'Numero du detail correction';
comment on column T_DETAIL_CORRECTION.DCO_TITRE
  is 'Titre de la correction';
comment on column T_DETAIL_CORRECTION.DCO_LIBELLE
  is 'Libelle de la correction';
comment on column T_DETAIL_CORRECTION.DCO_DTE_SAISI
  is 'date de la correction';
comment on column T_DETAIL_CORRECTION.DCO_PID_CODE
  is 'Numero de la pièce';
comment on column T_DETAIL_CORRECTION.DCO_DAC_CODE
  is 'Code du DAO';
comment on column T_DETAIL_CORRECTION.DCO_FON_COD_SAISI
  is 'Fonction de la correction';
comment on column T_DETAIL_CORRECTION.DCO_OPE_MATRICULE
  is 'Matricule de l''acteur de la correction';
comment on column T_DETAIL_CORRECTION.DCO_OBSERVATION
  is 'Autre Observation';
comment on column T_DETAIL_CORRECTION.DCO_COR_NUM
  is 'Numéro de la correction (T_correction_Dac)';
alter table T_DETAIL_CORRECTION
  add constraint DCO_NUM_PK primary key (DCO_NUM);
alter table T_DETAIL_CORRECTION
  add constraint DCO_COR_NUM_FK foreign key (DCO_COR_NUM)
  references T_CORRECTION_DAC (COR_NUM);
alter table T_DETAIL_CORRECTION
  add constraint DCO_DAC_CODE_FK foreign key (DCO_DAC_CODE)
  references T_DAC_SPECS (DAC_CODE);
alter table T_DETAIL_CORRECTION
  add constraint DCO_FON_COD_SAISI_FK foreign key (DCO_FON_COD_SAISI)
  references T_FONCTION (FON_COD);
alter table T_DETAIL_CORRECTION
  add constraint DCO_OPE_MATRICULE_FK foreign key (DCO_OPE_MATRICULE)
  references T_OPERATEUR (OPE_MATRICULE);
alter table T_DETAIL_CORRECTION
  add constraint DCO_PID_CODE_FK foreign key (DCO_PID_CODE)
  references T_PIECES_DACS (PID_CODE);

prompt
prompt Creating table T_NATURE_PIECE
prompt =============================
prompt
create table T_NATURE_PIECE
(
  NAP_CODE              VARCHAR2(5) not null,
  NAP_NAP_LIBELLE_COURT VARCHAR2(500) not null,
  NAP_NAP_LIBELLE_LONG  VARCHAR2(1000)
)
;
comment on table T_NATURE_PIECE
  is 'Liste des NATURES DE PIECES';
alter table T_NATURE_PIECE
  add constraint NAP_PK primary key (NAP_CODE);

prompt
prompt Creating table T_DOSSIER_AGPM
prompt =============================
prompt
create table T_DOSSIER_AGPM
(
  DAG_ID          NUMBER(10) not null,
  DAG_NAP_CODE    VARCHAR2(5) not null,
  DAG_AGP_ID      NUMBER(10) not null,
  DAG_CODE        VARCHAR2(500),
  DAG_LIBELLE     VARCHAR2(500),
  DAG_COMMENTAIRE VARCHAR2(500),
  DAG_REFERENCE   VARCHAR2(500)
)
;
comment on table T_DOSSIER_AGPM
  is 'Histosisation des documents';
alter table T_DOSSIER_AGPM
  add constraint PK_T_DOSSIER_AGPM primary key (DAG_ID);
alter table T_DOSSIER_AGPM
  add constraint FK_T_DAG_FK_T_AGP foreign key (DAG_AGP_ID)
  references T_AGPM (AGP_ID);
alter table T_DOSSIER_AGPM
  add constraint FK_T_DAG_FK_T_NAP foreign key (DAG_NAP_CODE)
  references T_NATURE_PIECE (NAP_CODE);
create index FK_T_HA_R_T_AG_FK on T_DOSSIER_AGPM (DAG_AGP_ID);
create index FK_T_HA_R_T_N_FK on T_DOSSIER_AGPM (DAG_NAP_CODE);

prompt
prompt Creating table T_NATURE_DOCUMENTS
prompt =================================
prompt
create table T_NATURE_DOCUMENTS
(
  NAD_CODE    VARCHAR2(3) not null,
  NAD_LIBELLE VARCHAR2(500),
  NAD_ABREGE  VARCHAR2(20),
  NAD_TYPE    VARCHAR2(3)
)
;
comment on table T_NATURE_DOCUMENTS
  is 'Nature de Document (DAO; ANNEXE; AUTRES)';
comment on column T_NATURE_DOCUMENTS.NAD_ABREGE
  is 'Code de la Nature';
alter table T_NATURE_DOCUMENTS
  add constraint PK_T_NATURE_DOCUMENT primary key (NAD_CODE);

prompt
prompt Creating table T_DOSSIER_DACS
prompt =============================
prompt
create table T_DOSSIER_DACS
(
  DDA_ID          NUMBER not null,
  DDA_NOM         VARCHAR2(200),
  DDA_DTE_SAISI   DATE,
  DDA_STA_CODE    VARCHAR2(3),
  DDA_DAC_CODE    VARCHAR2(20),
  DDA_PID_CODE    NUMBER,
  DDA_REFERENCE   VARCHAR2(500),
  DDA_COMMENTAIRE VARCHAR2(500),
  DDA_NAD_CODE    VARCHAR2(3)
)
;
comment on column T_DOSSIER_DACS.DDA_ID
  is 'Identifiant du dossier d''appel à la concurrence';
comment on column T_DOSSIER_DACS.DDA_NOM
  is 'nom du fichier  d''appel à la concurrence';
comment on column T_DOSSIER_DACS.DDA_DTE_SAISI
  is 'date de création du dossier d''appel à la concurrence';
comment on column T_DOSSIER_DACS.DDA_STA_CODE
  is 'statut du du dossier d''appel à la concurrence';
comment on column T_DOSSIER_DACS.DDA_DAC_CODE
  is 'code du dossier d''appel à la concurrence';
comment on column T_DOSSIER_DACS.DDA_PID_CODE
  is 'Code de la pièce du dossier';
comment on column T_DOSSIER_DACS.DDA_REFERENCE
  is 'Référence du dossier (Lien de téléchargement du dossier';
comment on column T_DOSSIER_DACS.DDA_COMMENTAIRE
  is 'Commentaire sur le dossier';
comment on column T_DOSSIER_DACS.DDA_NAD_CODE
  is 'Code Nature Documents';
alter table T_DOSSIER_DACS
  add constraint DDA_ID_PK primary key (DDA_ID);
alter table T_DOSSIER_DACS
  add constraint DDA_DAC_CODE_FK foreign key (DDA_DAC_CODE)
  references T_DAC_SPECS (DAC_CODE);
alter table T_DOSSIER_DACS
  add constraint DDA_PID_CODE_FK foreign key (DDA_PID_CODE)
  references T_PIECES_DACS (PID_CODE);
alter table T_DOSSIER_DACS
  add constraint FK_T_DOSSIERDAC_FK_T_DDA foreign key (DDA_NAD_CODE)
  references T_NATURE_DOCUMENTS (NAD_CODE);

prompt
prompt Creating table T_DOSSIER_PLAN_GENERAL
prompt =====================================
prompt
create table T_DOSSIER_PLAN_GENERAL
(
  DPG_ID          NUMBER(10) not null,
  DPG_NAP_CODE    VARCHAR2(5) not null,
  DPG_GPG_ID      NUMBER(10) not null,
  DPG_CODE        VARCHAR2(500),
  DPG_LIBELLE     VARCHAR2(500),
  DPG_COMMENTAIRE VARCHAR2(500),
  DPG_REFERENCE   VARCHAR2(500)
)
;
comment on table T_DOSSIER_PLAN_GENERAL
  is 'Histosisation des documents';
alter table T_DOSSIER_PLAN_GENERAL
  add constraint PK_T_DOSSIER_PLAN_GENERAL primary key (DPG_ID);
alter table T_DOSSIER_PLAN_GENERAL
  add constraint FK_T_DPG_FK_T_AGP foreign key (DPG_GPG_ID)
  references T_DETAIL_PLAN_GENERAL (GPG_ID);
alter table T_DOSSIER_PLAN_GENERAL
  add constraint FK_T_DPG_FK_T_NAP foreign key (DPG_NAP_CODE)
  references T_NATURE_PIECE (NAP_CODE);
create index FK_T_HA_R_T_DPG_FK on T_DOSSIER_PLAN_GENERAL (DPG_GPG_ID);
create index FK_T_HA_R_T_NAP_FK on T_DOSSIER_PLAN_GENERAL (DPG_NAP_CODE);

prompt
prompt Creating table T_FINANCEMENT_PGPM
prompt =================================
prompt
create table T_FINANCEMENT_PGPM
(
  FIP_ID             NUMBER(10) not null,
  FIP_DEV_CODE       VARCHAR2(8) not null,
  FIP_BAI_CODE       VARCHAR2(5) not null,
  FIP_SOU_CODE       VARCHAR2(5) not null,
  FIP_GPG_ID         NUMBER(10) not null,
  FIP_MONTANT_CFA    NUMBER(15,2),
  FIP_MONTANT_DEVISE NUMBER(15,2),
  FIP_COMMENTAIRE    VARCHAR2(500)
)
;
comment on column T_FINANCEMENT_PGPM.FIP_MONTANT_CFA
  is 'Montant en FCFA';
comment on column T_FINANCEMENT_PGPM.FIP_MONTANT_DEVISE
  is 'Montant ne devise correspontante';
alter table T_FINANCEMENT_PGPM
  add constraint PK_T_FINANCEMENT_PGPM primary key (FIP_ID);
alter table T_FINANCEMENT_PGPM
  add constraint FK_T_FIP_FK_T_BAI foreign key (FIP_BAI_CODE)
  references T_BAILLEUR (BAI_CODE);
alter table T_FINANCEMENT_PGPM
  add constraint FK_T_FIP_FK_T_DEV foreign key (FIP_DEV_CODE)
  references T_DEVISE (DEV_CODE);
alter table T_FINANCEMENT_PGPM
  add constraint FK_T_FIP_FK_T_PRO foreign key (FIP_GPG_ID)
  references T_DETAIL_PLAN_GENERAL (GPG_ID);
alter table T_FINANCEMENT_PGPM
  add constraint FK_T_FIP_FK_T_SOU foreign key (FIP_SOU_CODE)
  references T_SOURCE_FINANCEMENT (SOU_CODE);
create index FK_T_FP_R_T_B_FK on T_FINANCEMENT_PGPM (FIP_BAI_CODE);
create index FK_T_FP_R_T_D_FK on T_FINANCEMENT_PGPM (FIP_DEV_CODE);
create index FK_T_FP_R_T_DP_FK on T_FINANCEMENT_PGPM (FIP_GPG_ID);
create index FK_T_FP_R_T_S_FK on T_FINANCEMENT_PGPM (FIP_SOU_CODE);

prompt
prompt Creating table T_FINANCEMENT_PPM
prompt ================================
prompt
create table T_FINANCEMENT_PPM
(
  FPP_ID             NUMBER(10) not null,
  FPP_DEV_CODE       VARCHAR2(8) not null,
  FPP_BAI_CODE       VARCHAR2(5) not null,
  FPP_SOU_CODE       VARCHAR2(5) not null,
  FPP_DPP_ID         NUMBER(10) not null,
  FPP_MONTANT_CFA    NUMBER(15,2),
  FPP_MONTANT_DEVISE NUMBER(15,2),
  FPP_COMMENTAIRE    VARCHAR2(500)
)
;
comment on column T_FINANCEMENT_PPM.FPP_MONTANT_CFA
  is 'Montant en FCFA';
comment on column T_FINANCEMENT_PPM.FPP_MONTANT_DEVISE
  is 'Montant ne devise correspontante';
alter table T_FINANCEMENT_PPM
  add constraint PK_T_FINANCEMENT_PPM primary key (FPP_ID);
alter table T_FINANCEMENT_PPM
  add constraint FK_T_FPP_FK_T_BAI foreign key (FPP_BAI_CODE)
  references T_BAILLEUR (BAI_CODE);
alter table T_FINANCEMENT_PPM
  add constraint FK_T_FPP_FK_T_DEV foreign key (FPP_DEV_CODE)
  references T_DEVISE (DEV_CODE);
alter table T_FINANCEMENT_PPM
  add constraint FK_T_FPP_FK_T_DPP foreign key (FPP_DPP_ID)
  references T_DETAIL_PLAN_PASSATION (DPP_ID);
alter table T_FINANCEMENT_PPM
  add constraint FK_T_FPP_FK_T_SOU foreign key (FPP_SOU_CODE)
  references T_SOURCE_FINANCEMENT (SOU_CODE);
create index FK_T_FPP_R_T_B_FK on T_FINANCEMENT_PPM (FPP_BAI_CODE);
create index FK_T_FPP_R_T_D_FK on T_FINANCEMENT_PPM (FPP_DEV_CODE);
create index FK_T_FPP_R_T_DPP_FK on T_FINANCEMENT_PPM (FPP_DPP_ID);
create index FK_T_FPP_R_T_S_FK on T_FINANCEMENT_PPM (FPP_SOU_CODE);

prompt
prompt Creating table T_HISTO_AGPM
prompt ===========================
prompt
create table T_HISTO_AGPM
(
  HAG_ID       NUMBER(10) not null,
  HAG_AGP_ID   NUMBER(10) not null,
  HAG_STA_CODE VARCHAR2(3) not null,
  HAG_DATE     DATE,
  HAG_MOTIF    VARCHAR2(1000),
  HAG_FON_COD  VARCHAR2(12)
)
;
alter table T_HISTO_AGPM
  add constraint PK_T_HISTO_AGPM primary key (HAG_ID);
alter table T_HISTO_AGPM
  add constraint FK_HAG_FON_COD foreign key (HAG_FON_COD)
  references T_FONCTION (FON_COD);
alter table T_HISTO_AGPM
  add constraint FK_T_HAG_FK_T_AGP foreign key (HAG_AGP_ID)
  references T_AGPM (AGP_ID);
alter table T_HISTO_AGPM
  add constraint FK_T_HAG_FK_T_STA foreign key (HAG_STA_CODE)
  references T_STATUT (STA_CODE);
create index FK_T_HA_R_T_A_FK on T_HISTO_AGPM (HAG_AGP_ID);
create index FK_T_HA_R_T_S_FK on T_HISTO_AGPM (HAG_STA_CODE);

prompt
prompt Creating table T_HISTO_DAC
prompt ==========================
prompt
create table T_HISTO_DAC
(
  HAC_ID          NUMBER(10) not null,
  HAC_FON_COD     VARCHAR2(12) not null,
  HAC_OPE_MAT     VARCHAR2(25) not null,
  HAC_DAC_CODE    VARCHAR2(20) not null,
  HAC_STA_CODE    VARCHAR2(3) not null,
  HAC_DATE        DATE,
  HAC_COMMENTAIRE VARCHAR2(1000)
)
;
alter table T_HISTO_DAC
  add constraint PK_T_HISTO_DAC primary key (HAC_ID);
alter table T_HISTO_DAC
  add constraint FK_HAC_FK_FON_COD foreign key (HAC_FON_COD)
  references T_FONCTION (FON_COD);
alter table T_HISTO_DAC
  add constraint FK_T_HAC_FK_T_DAC foreign key (HAC_DAC_CODE)
  references T_DAC_SPECS (DAC_CODE);
alter table T_HISTO_DAC
  add constraint FK_T_HAC_FK_T_OPE foreign key (HAC_OPE_MAT)
  references T_OPERATEUR (OPE_MATRICULE);
alter table T_HISTO_DAC
  add constraint FK_T_HAC_FK_T_STA foreign key (HAC_STA_CODE)
  references T_STATUT (STA_CODE);

prompt
prompt Creating table T_HISTO_PLAN_GENERAL
prompt ===================================
prompt
create table T_HISTO_PLAN_GENERAL
(
  HPG_ID       NUMBER(10) not null,
  HPG_FON_COD  VARCHAR2(12) not null,
  HPG_GPG_ID   NUMBER(10) not null,
  HPG_STA_CODE VARCHAR2(3) not null,
  HPG_DATE     DATE,
  HPG_MOTIF    VARCHAR2(1000)
)
;
comment on table T_HISTO_PLAN_GENERAL
  is 'Histosisation du cycle de vie PLAN_GENERAL';
alter table T_HISTO_PLAN_GENERAL
  add constraint PK_T_HISTO_PLAN_GENERAL primary key (HPG_ID);
alter table T_HISTO_PLAN_GENERAL
  add constraint FK_T_HISTO_PLAN_FON foreign key (HPG_FON_COD)
  references T_FONCTION (FON_COD);
alter table T_HISTO_PLAN_GENERAL
  add constraint FK_T_HPG_FK_T_GPG foreign key (HPG_GPG_ID)
  references T_DETAIL_PLAN_GENERAL (GPG_ID);
alter table T_HISTO_PLAN_GENERAL
  add constraint FK_T_HPG_FK_T_STA foreign key (HPG_STA_CODE)
  references T_STATUT (STA_CODE);
create index FK_T_HG_R_T_A_FK on T_HISTO_PLAN_GENERAL (HPG_GPG_ID);
create index FK_T_HG_R_T_F_FK on T_HISTO_PLAN_GENERAL (HPG_FON_COD);
create index FK_T_HG_R_T_S_FK on T_HISTO_PLAN_GENERAL (HPG_STA_CODE);

prompt
prompt Creating table T_HISTO_PLAN_PASSATION
prompt =====================================
prompt
create table T_HISTO_PLAN_PASSATION
(
  HPP_ID       NUMBER(10) not null,
  HPP_FON_COD  VARCHAR2(12) not null,
  HPP_DPP_ID   NUMBER(10) not null,
  HPP_STA_CODE VARCHAR2(3) not null,
  HPP_DATE     DATE,
  HPP_MOTIF    VARCHAR2(1000)
)
;
comment on table T_HISTO_PLAN_PASSATION
  is 'Histosisation du cycle de vie PLAN PASSATION';
alter table T_HISTO_PLAN_PASSATION
  add constraint PK_T_HISTO_PLAN_PASSATION primary key (HPP_ID);
alter table T_HISTO_PLAN_PASSATION
  add constraint FK_HPP_FK_FON_COD foreign key (HPP_FON_COD)
  references T_FONCTION (FON_COD);
alter table T_HISTO_PLAN_PASSATION
  add constraint FK_T_HPP_FK_T_AGP foreign key (HPP_DPP_ID)
  references T_DETAIL_PLAN_PASSATION (DPP_ID);
alter table T_HISTO_PLAN_PASSATION
  add constraint FK_T_HPP_FK_T_STA foreign key (HPP_STA_CODE)
  references T_STATUT (STA_CODE);
create index FK_T_HP_R_T_DP_FK on T_HISTO_PLAN_PASSATION (HPP_DPP_ID);
create index FK_T_HP_R_T_F_FK on T_HISTO_PLAN_PASSATION (HPP_FON_COD);
create index FK_T_HP_R_T_S_FK on T_HISTO_PLAN_PASSATION (HPP_STA_CODE);

prompt
prompt Creating table T_LOT_AAO
prompt ========================
prompt
create table T_LOT_AAO
(
  LAA_ID             NUMBER not null,
  LAA_AAO_CODE       VARCHAR2(20),
  LAA_OBJET          VARCHAR2(1000),
  LAA_OBSERVATION    VARCHAR2(200),
  LAA_MT_CAUT        NUMBER,
  LAA_MT_EST         NUMBER,
  LAA_DTE_SAISI      DATE,
  LAA_STA_CODE       VARCHAR2(3),
  LAA_FON_COD_SAISI  VARCHAR2(20),
  LAA_FON_COD_CPMP   VARCHAR2(20),
  LAA_OPE_MATRICULE  VARCHAR2(20),
  LAA_LIEU_EXE       VARCHAR2(1000),
  LAA_LBG_IMPUTATION VARCHAR2(50),
  LAA_NUM            NUMBER,
  LAA_COUT_LOT       NUMBER,
  LAA_DAC_CODE       VARCHAR2(20)
)
;
comment on column T_LOT_AAO.LAA_ID
  is 'Numéro du lot';
comment on column T_LOT_AAO.LAA_AAO_CODE
  is 'Code de l''appel d''offre';
comment on column T_LOT_AAO.LAA_OBJET
  is 'Objet du lot';
comment on column T_LOT_AAO.LAA_OBSERVATION
  is 'Observation sur le lot';
comment on column T_LOT_AAO.LAA_MT_CAUT
  is 'Montant du cautionnement';
comment on column T_LOT_AAO.LAA_MT_EST
  is 'Montant estimatif du lot';
comment on column T_LOT_AAO.LAA_DTE_SAISI
  is 'date de saisi du lot';
comment on column T_LOT_AAO.LAA_STA_CODE
  is 'statut du lot';
comment on column T_LOT_AAO.LAA_FON_COD_SAISI
  is 'Code de l''autorité Contractante';
comment on column T_LOT_AAO.LAA_FON_COD_CPMP
  is 'Code de la cellule de passation';
comment on column T_LOT_AAO.LAA_OPE_MATRICULE
  is 'Matricule de l''acteur connecté';
comment on column T_LOT_AAO.LAA_LIEU_EXE
  is 'Lieu d''exécution du lot';
comment on column T_LOT_AAO.LAA_LBG_IMPUTATION
  is 'Imputation du lot';
comment on column T_LOT_AAO.LAA_NUM
  is 'Numéro d''ordre du lot (1, 2, 3)';
comment on column T_LOT_AAO.LAA_COUT_LOT
  is 'Cout de vente du lot';
alter table T_LOT_AAO
  add constraint LAA_ID_PK primary key (LAA_ID);
alter table T_LOT_AAO
  add constraint LAA_AAO_CODE_FK foreign key (LAA_AAO_CODE)
  references T_AVIS_APPEL_OFFRE (AAO_CODE);
alter table T_LOT_AAO
  add constraint LAA_DAC_CODE_FK foreign key (LAA_DAC_CODE)
  references T_DAC_SPECS (DAC_CODE);
alter table T_LOT_AAO
  add constraint LAA_FON_COD_CPMP_FK foreign key (LAA_FON_COD_CPMP)
  references T_FONCTION (FON_COD);
alter table T_LOT_AAO
  add constraint LAA_FON_COD_SAISI_FK foreign key (LAA_FON_COD_SAISI)
  references T_FONCTION (FON_COD);
alter table T_LOT_AAO
  add constraint LAA_LBG_IMPUTATION_FK foreign key (LAA_LBG_IMPUTATION)
  references T_L_BUDGETS (LBG_CODE);

prompt
prompt Creating table T_MOTDEPASSE
prompt ===========================
prompt
create table T_MOTDEPASSE
(
  MDP_ID            NUMBER(10) not null,
  MDP_OPE_MATRICULE VARCHAR2(25),
  MDP_MOTDEPASSE    VARCHAR2(250),
  MDP_STATUT        NUMBER(1),
  MDP_DATE          DATE
)
;
alter table T_MOTDEPASSE
  add constraint PK_T_MOTDEPASSE primary key (MDP_ID);
alter table T_MOTDEPASSE
  add constraint FK_T_MOTDEP_FK_T_MOTD_T_OPERAT foreign key (MDP_OPE_MATRICULE)
  references T_OPERATEUR (OPE_MATRICULE);
create index FK_T_MO_REL_T_OP_FK on T_MOTDEPASSE (MDP_OPE_MATRICULE);

prompt
prompt Creating table T_OBJECTIF_GEN
prompt =============================
prompt
create table T_OBJECTIF_GEN
(
  OBG_ID            NUMBER(10) not null,
  OBG_PRO_ID        NUMBER(10),
  OBG_CODE          VARCHAR2(10),
  OBG_LIBELLE_COURT VARCHAR2(500),
  OBG_LIBELLE_LONG  VARCHAR2(1000)
)
;
comment on table T_OBJECTIF_GEN
  is 'Liste des OBJECTIFS GENERAUX';
comment on column T_OBJECTIF_GEN.OBG_ID
  is 'ID de la OBJECTIF_GEN';
comment on column T_OBJECTIF_GEN.OBG_CODE
  is 'Code du OBJECTIF_GEN de la OBJECTIF_GEN après sa validation';
alter table T_OBJECTIF_GEN
  add constraint OBG_PK primary key (OBG_ID);
alter table T_OBJECTIF_GEN
  add constraint FK_T_OBG_FK_T_PRO foreign key (OBG_PRO_ID)
  references T_PROJET (PRO_ID);
create index FK_T_P_T_O_FK on T_OBJECTIF_GEN (OBG_PRO_ID);

prompt
prompt Creating table T_OBJECTIF_SPEC
prompt ==============================
prompt
create table T_OBJECTIF_SPEC
(
  OBS_ID            NUMBER(10) not null,
  OBS_OBG_ID        NUMBER(10),
  OBS_CODE          VARCHAR2(10),
  OBS_LIBELLE_COURT VARCHAR2(500),
  OBS_LIBELLE_LONG  VARCHAR2(1000)
)
;
comment on table T_OBJECTIF_SPEC
  is 'Liste des OBJECTIFS SPECIFIQUES';
comment on column T_OBJECTIF_SPEC.OBS_ID
  is 'ID de la OBJECTIF_SPEC';
comment on column T_OBJECTIF_SPEC.OBS_CODE
  is 'Code de la OBJECTIF_SPEC après sa validation';
alter table T_OBJECTIF_SPEC
  add constraint OBS_PK primary key (OBS_ID);
alter table T_OBJECTIF_SPEC
  add constraint FK_T_OBS_FK_T_OBG foreign key (OBS_OBG_ID)
  references T_OBJECTIF_GEN (OBG_ID);
create index FK_T_P_T_OS_FK on T_OBJECTIF_SPEC (OBS_OBG_ID);

prompt
prompt Creating table T_RETRAIT
prompt ========================
prompt
create table T_RETRAIT
(
  RET_ID            NUMBER(10) not null,
  RET_DAC_CODE      VARCHAR2(20),
  RET_NOM           VARCHAR2(1000),
  RET_ADRESSE       VARCHAR2(500),
  RET_MAIL          VARCHAR2(500),
  RET_TEL           VARCHAR2(500),
  RET_PIECE_NUMERO  VARCHAR2(500),
  RET_DATE          DATE,
  RET_TYPE_PIECE    VARCHAR2(50),
  RET_FON_COD       VARCHAR2(12),
  RET_OPE_MATRICULE VARCHAR2(25)
)
;
alter table T_RETRAIT
  add constraint PK_T_RETRAIT_R primary key (RET_ID);
alter table T_RETRAIT
  add constraint FK_RET_FON_COD foreign key (RET_FON_COD)
  references T_FONCTION (FON_COD);
alter table T_RETRAIT
  add constraint FK_RET_OPE_MAT foreign key (RET_OPE_MATRICULE)
  references T_OPERATEUR (OPE_MATRICULE);
alter table T_RETRAIT
  add constraint FK_RET_REQ_ID foreign key (RET_DAC_CODE)
  references T_DAC_SPECS (DAC_CODE);

prompt
prompt Creating table T_TEMP_PARAMETRE
prompt ===============================
prompt
create table T_TEMP_PARAMETRE
(
  TEMP_NUM           NUMBER not null,
  TEMP_TYPE          VARCHAR2(500),
  TEMP_OPE_MATRICULE VARCHAR2(500),
  TEMP_DTE_SAISI     DATE,
  TEMP_CHAMP_01      VARCHAR2(500),
  TEMP_CHAMP_02      VARCHAR2(500),
  TEMP_CHAMP_03      VARCHAR2(500),
  TEMP_CHAMP_04      VARCHAR2(500),
  TEMP_CHAMP_05      VARCHAR2(500),
  TEMP_CHAMP_06      VARCHAR2(500),
  TEMP_CHAMP_07      VARCHAR2(500),
  TEMP_CHAMP_08      VARCHAR2(500),
  TEMP_CHAMP_09      VARCHAR2(500),
  TEMP_CHAMP_10      VARCHAR2(500),
  TEMP_CHAMP_11      VARCHAR2(500),
  TEMP_CHAMP_12      VARCHAR2(500),
  TEMP_CHAMP_13      VARCHAR2(500),
  TEMP_CHAMP_14      VARCHAR2(500),
  TEMP_CHAMP_15      VARCHAR2(500),
  TEMP_CHAMP_16      VARCHAR2(500),
  TEMP_CHAMP_17      VARCHAR2(500),
  TEMP_CHAMP_18      VARCHAR2(500),
  TEMP_CHAMP_19      VARCHAR2(500),
  TEMP_CHAMP_20      VARCHAR2(500)
)
;
comment on column T_TEMP_PARAMETRE.TEMP_NUM
  is 'Identifiant de la variable';
comment on column T_TEMP_PARAMETRE.TEMP_TYPE
  is 'Type de l''operation (LOT, ETC...)';
comment on column T_TEMP_PARAMETRE.TEMP_OPE_MATRICULE
  is 'Acteur de la saisie';
comment on column T_TEMP_PARAMETRE.TEMP_DTE_SAISI
  is 'Date de la création de l''enregistrement';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_01
  is 'Champ 01 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_02
  is 'Champ 02 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_03
  is 'Champ 03 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_04
  is 'Champ 04 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_05
  is 'Champ 05 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_06
  is 'Champ 06 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_07
  is 'Champ 07 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_08
  is 'Champ 08 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_09
  is 'Champ 09 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_10
  is 'Champ 10 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_11
  is 'Champ 11 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_12
  is 'Champ 12 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_13
  is 'Champ 13 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_14
  is 'Champ 14 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_15
  is 'Champ 15 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_16
  is 'Champ 16 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_17
  is 'Champ 17 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_18
  is 'Champ 18 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_19
  is 'Champ 19 de la table parametre';
comment on column T_TEMP_PARAMETRE.TEMP_CHAMP_20
  is 'Champ 20 de la table parametre';
alter table T_TEMP_PARAMETRE
  add constraint TEMP_NUM_PK primary key (TEMP_NUM);
alter table T_TEMP_PARAMETRE
  add constraint TEMP_OPE_MATRICULE_FK foreign key (TEMP_OPE_MATRICULE)
  references T_OPERATEUR (OPE_MATRICULE);

prompt
prompt Creating sequence SEQ_ADA
prompt =========================
prompt
create sequence SEQ_ADA
minvalue 1
maxvalue 9999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_ADGP
prompt ==========================
prompt
create sequence SEQ_ADGP
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_AFF
prompt =========================
prompt
create sequence SEQ_AFF
minvalue 1
maxvalue 9999999999
start with 14
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_AFF_DAO
prompt =============================
prompt
create sequence SEQ_AFF_DAO
minvalue 1
maxvalue 99999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_AFF_PGPM
prompt ==============================
prompt
create sequence SEQ_AFF_PGPM
minvalue 1
maxvalue 9999999999
start with 29
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_AFF_PPM
prompt =============================
prompt
create sequence SEQ_AFF_PPM
minvalue 1
maxvalue 9999999999
start with 54
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_AGP
prompt =========================
prompt
create sequence SEQ_AGP
minvalue 1
maxvalue 9999999999
start with 39
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_ASS
prompt =========================
prompt
create sequence SEQ_ASS
minvalue 1
maxvalue 9999999999
start with 5
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_BES
prompt =========================
prompt
create sequence SEQ_BES
minvalue 1
maxvalue 9999999999
start with 9
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_CHR
prompt =========================
prompt
create sequence SEQ_CHR
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_CMP
prompt =========================
prompt
create sequence SEQ_CMP
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_COM
prompt =========================
prompt
create sequence SEQ_COM
minvalue 1
maxvalue 9999999999
start with 8
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_COMM
prompt ==========================
prompt
create sequence SEQ_COMM
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_COMS
prompt ==========================
prompt
create sequence SEQ_COMS
minvalue 1
maxvalue 9999999999
start with 101
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_COM_SPEC
prompt ==============================
prompt
create sequence SEQ_COM_SPEC
minvalue 1
maxvalue 99999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_COR
prompt =========================
prompt
create sequence SEQ_COR
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_COR_NUM
prompt =============================
prompt
create sequence SEQ_COR_NUM
minvalue 1
maxvalue 9999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_DAG
prompt =========================
prompt
create sequence SEQ_DAG
minvalue 1
maxvalue 9999999999
start with 12
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_DAGP
prompt ==========================
prompt
create sequence SEQ_DAGP
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_DCS
prompt =========================
prompt
create sequence SEQ_DCS
minvalue 1
maxvalue 9999999999
start with 101
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_DDA
prompt =========================
prompt
create sequence SEQ_DDA
minvalue 1
maxvalue 9999999999
start with 11
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_DEC
prompt =========================
prompt
create sequence SEQ_DEC
minvalue 1
maxvalue 9999999999
start with 21
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_DET_SEA
prompt =============================
prompt
create sequence SEQ_DET_SEA
minvalue 1
maxvalue 99999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_DPG
prompt =========================
prompt
create sequence SEQ_DPG
minvalue 1
maxvalue 9999999999
start with 24
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_DPP
prompt =========================
prompt
create sequence SEQ_DPP
minvalue 1
maxvalue 9999999999
start with 66
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_DTA
prompt =========================
prompt
create sequence SEQ_DTA
minvalue 1
maxvalue 9999999999
start with 6
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_FIN
prompt =========================
prompt
create sequence SEQ_FIN
minvalue 1
maxvalue 9999999999
start with 30
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_FIP
prompt =========================
prompt
create sequence SEQ_FIP
minvalue 1
maxvalue 9999999999
start with 36
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_FPP
prompt =========================
prompt
create sequence SEQ_FPP
minvalue 1
maxvalue 9999999999
start with 26
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_GPG
prompt =========================
prompt
create sequence SEQ_GPG
minvalue 1
maxvalue 9999999999
start with 45
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_HAG
prompt =========================
prompt
create sequence SEQ_HAG
minvalue 1
maxvalue 9999999999
start with 75
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_HDC
prompt =========================
prompt
create sequence SEQ_HDC
minvalue 1
maxvalue 9999999999
start with 34
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_HPG
prompt =========================
prompt
create sequence SEQ_HPG
minvalue 1
maxvalue 9999999999
start with 79
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_HPP
prompt =========================
prompt
create sequence SEQ_HPP
minvalue 1
maxvalue 9999999999
start with 80
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_LAA
prompt =========================
prompt
create sequence SEQ_LAA
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_LIAD
prompt ==========================
prompt
create sequence SEQ_LIAD
minvalue 1
maxvalue 9999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_LIAE
prompt ==========================
prompt
create sequence SEQ_LIAE
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_MDP
prompt =========================
prompt
create sequence SEQ_MDP
minvalue 1
maxvalue 9999999999
start with 3
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_OBG
prompt =========================
prompt
create sequence SEQ_OBG
minvalue 1
maxvalue 9999999999
start with 8
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_OBS
prompt =========================
prompt
create sequence SEQ_OBS
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_PID
prompt =========================
prompt
create sequence SEQ_PID
minvalue 1
maxvalue 9999999999
start with 64
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_PLG
prompt =========================
prompt
create sequence SEQ_PLG
minvalue 1
maxvalue 9999999999
start with 41
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_PLP
prompt =========================
prompt
create sequence SEQ_PLP
minvalue 1
maxvalue 9999999999
start with 43
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_PRO
prompt =========================
prompt
create sequence SEQ_PRO
minvalue 1
maxvalue 9999999999
start with 39
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_REG
prompt =========================
prompt
create sequence SEQ_REG
minvalue 1
maxvalue 9999999999
start with 3
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_RET
prompt =========================
prompt
create sequence SEQ_RET
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SEA
prompt =========================
prompt
create sequence SEQ_SEA
minvalue 1
maxvalue 9999999999
start with 20
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SEA_NUM
prompt =============================
prompt
create sequence SEQ_SEA_NUM
minvalue 1
maxvalue 99999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_TDA
prompt =========================
prompt
create sequence SEQ_TDA
minvalue 1
maxvalue 9999999999
start with 46
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_T_DETAIL_CORRECTION
prompt =========================================
prompt
create sequence SEQ_T_DETAIL_CORRECTION
minvalue 1
maxvalue 99999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_TEMP_PARAMETRE
prompt ====================================
prompt
create sequence SEQ_TEMP_PARAMETRE
minvalue 1
maxvalue 99999999999999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_LOT_AAO
prompt ===============================
prompt
create sequence SEQ_T_LOT_AAO
minvalue 1
maxvalue 99999999999999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_TYP
prompt =========================
prompt
create sequence SEQ_TYP
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating view V_AGPM
prompt ====================
prompt
create or replace view v_agpm as
select a.agp_id,a.agp_ges_code,m.min_libelle_court,m.min_libelle,f.fon_cod,f.fon_cod||' - '||f.fon_libelle AC
,p.pro_libelle, a.agp_type_dao,a.agp_mode_passation,p.pro_montant_tot_cfa
,a.agp_sta_code,a.agp_str_code, a.agp_actif, a.agp_statut_retour, d.dec_organ_exec_libelle
from t_agpm a, t_projet p, t_ministere m,t_structure st, t_fonction f, t_declarant d
where a.agp_pro_id = p.pro_id
and a.agp_str_code = st.str_code
and m.min_code = st.str_min_code
and a.agp_fon_cod = f.fon_cod
and a.agp_dec_id = d.dec_id
/

prompt
prompt Creating view V_AGPM_DECLARANT
prompt ==============================
prompt
create or replace view v_agpm_declarant as
select ag.agp_id,ag.agp_fon_cod,ag.agp_str_code,ag.agp_pro_id,ag.agp_acteur_saisie,dc.dec_pers_nom_prenom,dc.dec_organ_exec_libelle,dc.dec_pers_fonction,dc.dec_telephone,dc.dec_numero_porte,dc.dec_organ_exec_adresse,dc.dec_localisation,dc.dec_email,dc.dec_bp,dc.dec_cel,ag.agp_dec_id
from t_agpm ag, t_declarant dc
where ag.agp_dec_id = dc.dec_id
/

prompt
prompt Creating view V_AGPM_DETAILS
prompt ============================
prompt
create or replace view v_agpm_details as
select afg.aff_pro_id,pr.pro_id,pr.pro_libelle,pr.pro_description,pr.pro_titre,pr.pro_montant_tot_cfa,mi.min_libelle,mi.min_description,gs.ges_date_debut,gs.ges_date_fin,dc.dec_pers_nom_prenom,dc.dec_pers_fonction,dc.dec_telephone,dc.dec_organ_exec_libelle,dc.dec_organ_exec_adresse,dc.dec_numero_porte,dc.dec_localisation,dc.dec_email,dc.dec_bp,dc.dec_cel,afg.aff_agp_id,afg.aff_ges_code,afg.aff_agp_commentaire,afg.aff_agp_actif,afg.aff_agp_type_dao,afg.aff_agp_sta_code,rg.reg_libelle_long,rg.reg_libelle_court,f.fon_libelle,st.str_libelle_long,st.str_libelle_court
FROM t_affichage_agpm afg, t_projet pr, t_declarant dc, t_ministere mi,t_structure st ,t_gestion gs, t_fonction f, t_reglementation rg
WHERE afg.aff_pro_id = pr.pro_id
AND afg.aff_dec_id = dc.dec_id (+)
AND afg.aff_str_code = st.str_code(+)
AND mi.min_code = st.str_min_code
AND afg.aff_ges_code = gs.ges_code(+)
AND afg.aff_fon_cod = f.fon_cod (+)
AND pr.pro_id = rg.reg_id(+)
/

prompt
prompt Creating view V_AGPM_MINISTERE
prompt ==============================
prompt
create or replace view v_agpm_ministere as
select ag."AGP_ID",ag."AGP_STR_CODE",ag."AGP_FON_COD",ag."AGP_GES_CODE",ag."AGP_STA_CODE",ag."AGP_PRO_ID",ag."AGP_DEC_ID",ag."AGP_COMMENTAIRE",ag."AGP_TYPE_DAO",ag."AGP_MODE_PASSATION",ag."AGP_ACTIF",ag."AGP_STATUT_RETOUR",ag."AGP_ACTEUR_SAISIE",m.min_libelle
from t_agpm ag, t_ministere m, t_structure st
where ag.agp_str_code = st.str_code
and m.min_code = st.str_min_code
/

prompt
prompt Creating view V_AGPM_STATUT
prompt ===========================
prompt
CREATE OR REPLACE VIEW V_AGPM_STATUT AS
SELECT ha.hag_id,ha.hag_date,ha.hag_motif,ha.hag_sta_code,ha.hag_agp_id,ha.hag_fon_cod,ag.agp_pro_id,f.fon_libelle
from t_histo_agpm ha, t_fonction f, t_agpm ag
where ha.hag_fon_cod = f.fon_cod
and ha.hag_agp_id = ag.agp_id
/

prompt
prompt Creating view VB_AVIS_APPEL_OFFRE
prompt =================================
prompt
create or replace view vb_avis_appel_offre as
select "AAO_CODE","AAO_LIBELLE","AAO_DAC_CODE","AAO_DTE_SAISI","AAO_STA_CODE","AAO_DTE_PUB","AAO_DTE_OUV_TEC","AAO_DTE_HEUR_OUV","AAO_DTE_OUV_FIN","AAO_NBR_LOT","AAO_NBR_OUV","AAO_DELAI_VAL","AAO_FON_COD_AC","AAO_FON_CODE_CPMP","AAO_NAT_INT","AAO_TAUX","AAO_LIEU_EXE","AAO_NOM_RESP","AAO_INTER_PUB","AAO_CAUT_DEF_EXIG","AAO_BOMP_PUB","AAO_VENTE_PAR_LOT","AAO_AVIS_BAIL","AAO_MT_CAUT","AAO_MODE_PAIEMENT","AAO_COUT_DAC","AAO_LIEU_RECEP","AAO_DATE_RECEP","AAO_HEURE_RECEP","AAO_ADA_NUM" from T_AVIS_APPEL_OFFRE
/

prompt
prompt Creating view VB_CORRECTION_DAC
prompt ===============================
prompt
create or replace view vb_correction_dac as
select "COR_NUM","COR_DAC_CODE","COR_LIEBLLE","COR_DTE_SAISI","COR_OPE_MATRICULE" from t_correction_dac
/

prompt
prompt Creating view VB_DETAIL_CORRECTION
prompt ==================================
prompt
create or replace view vb_detail_correction as
select "DCO_NUM","DCO_TITRE","DCO_LIBELLE","DCO_DTE_SAISI","DCO_PID_CODE","DCO_DAC_CODE","DCO_FON_COD_SAISI","DCO_OPE_MATRICULE","DCO_OBSERVATION","DCO_COR_NUM" from T_DETAIL_CORRECTION
/

prompt
prompt Creating view V_BESOIN
prompt ======================
prompt
create or replace view v_besoin as
select bs.bes_id,bs.bes_libelle,bs.bes_pro_id,bs.bes_statut,rg.reg_libelle_long,rg.reg_libelle_court
from t_besoin bs, t_reglementation rg
where bs.bes_reg_id = rg.reg_id
/

prompt
prompt Creating view VB_LOT_AAO
prompt ========================
prompt
create or replace view vb_lot_aao as
select "LAA_ID","LAA_AAO_CODE","LAA_OBJET","LAA_OBSERVATION","LAA_MT_CAUT","LAA_MT_EST","LAA_DTE_SAISI","LAA_STA_CODE","LAA_FON_COD_SAISI","LAA_FON_COD_CPMP","LAA_OPE_MATRICULE","LAA_LIEU_EXE","LAA_LBG_IMPUTATION","LAA_NUM","LAA_COUT_LOT","LAA_DAC_CODE" from T_LOT_AAO
/

prompt
prompt Creating view VB_SEANCES
prompt ========================
prompt
create or replace view vb_seances as
select "SEA_NUM","SEA_LIBELLE","SEA_TSE_CODE","SEA_QUORUM","SEA_NBR_PLI","SEA_RES","SEA_STE_SAISI","SEA_FON_CODE" from T_SEANCES
/

prompt
prompt Creating view VB_TEMP_PARAMETRE_COM
prompt ===================================
prompt
create or replace view vb_temp_parametre_com as
select t.temp_num,
       t.temp_type,
       t.temp_ope_matricule,
       t.temp_dte_saisi,
       t.temp_champ_01 DCS_MBM_RESPO,
       t.temp_champ_02 DCS_NUM,
       t.temp_champ_03 DCS_DAC_CODE,
       t.temp_champ_04 DCS_FON_COD,
       t.temp_champ_05 DCS_SEA_QUORUM,
       t.temp_champ_06 DCS_SEA_NUM,
       t.temp_champ_07 DCS_DTE_SAISI,
       t.temp_champ_08 DCS_FON_COD_SAISI,
       t.temp_champ_09 DCS_OBSERVATION,
       t.temp_champ_10 DCS_COM_TCO_CODE,
       t.temp_champ_11 DCS_COM_NUM,
       t.temp_champ_12 DCS_NOM_MBM,
       t.temp_champ_13 DCS_PRE_MBM,
       t.temp_champ_14 DCS_TEL_MBM,
       t.temp_champ_15 DCS_PRESENT,
       t.temp_champ_16 DCS_COM_STR_CODE,
       t.temp_champ_17 DCS_OPE_MAT_SAISI,
       t.temp_champ_18 DCS_NBR_PLI,
       t.temp_champ_19 DCS_COM_TCT_CODE
from t_temp_parametre t where t.temp_type='COJO'
/

prompt
prompt Creating view VB_TEMP_PARAMETRE_CORRECTION
prompt ==========================================
prompt
create or replace view vb_temp_parametre_correction as
select TEMP_NUM, TEMP_TYPE, TEMP_OPE_MATRICULE DCO_OPE_MATRICULE, TEMP_DTE_SAISI DCO_DTE_SAISI,TEMP_CHAMP_01 DCO_TITRE, TEMP_CHAMP_02 DCO_LIBELLE,TEMP_CHAMP_03 DCO_PID_CODE, TEMP_CHAMP_04 DCO_DAC_CODE, TEMP_CHAMP_05 DCO_FON_COD_SAISI,TEMP_CHAMP_06 DCO_OBSERVATION, TEMP_CHAMP_07 DCO_COR_NUM from t_temp_parametre
/

prompt
prompt Creating view VB_TEMP_PARAMETRE_LOT
prompt ===================================
prompt
create or replace view vb_temp_parametre_lot as
select "TEMP_NUM" TEMP_NUM,
"TEMP_TYPE" TEMP_TYPE,
"TEMP_OPE_MATRICULE" TEMP_OPE_MATRICULE,
"TEMP_DTE_SAISI" TEMP_LAA_DTE_SAISI,-- Date de saisi
"TEMP_CHAMP_01"  TEMP_LAA_NBR_TOT_LOT,--nombre total de lot
"TEMP_CHAMP_02" TEMP_LAA_NBR_LOT_DEBUT, -- Générer le lot a partir de  :
"TEMP_CHAMP_03" TEMP_LAA_NBR_LOT_FIN, -- générér lot jusqu'a 
"TEMP_CHAMP_04" TEMP_LAA_LIB_GENERIQUE,-- numéro Générique du lot
"TEMP_CHAMP_05" TEMP_LAA_IMPUTATION,-- imputation du lot
"TEMP_CHAMP_06" TEMP_LAA_CAUT_LOT,--cautionnement du lot
"TEMP_CHAMP_07" TEMP_LAA_MT_LOT,-- Montant du lot si le DAO est vendu par lot
"TEMP_CHAMP_08" TEMP_LAA_AAO_CODE,--Code de l'avis
"TEMP_CHAMP_09" TEMP_LAA_AUTRE,
"TEMP_CHAMP_10" TEMP_LAA_AUTRE_1
from t_temp_parametre
/

prompt
prompt Creating view VB_TYPE_MARCHE
prompt ============================
prompt
create or replace view vb_type_marche as
select "TYM_CODE","TYM_LIBELLE_COURT","TYM_LIBELLE_LONG","TYM_TYM_CODE","TYM_GROUPE" from T_TYPE_MARCHE
/

prompt
prompt Creating view VB_TYPE_SEANCE
prompt ============================
prompt
create or replace view vb_type_seance as
select "TSE_CODE","TSE_LIBELLE","TSE_DTE_SAISI","TSE_FON_CODE","TSE_OPE_MATRICULE" from T_TYPE_SEANCE
/

prompt
prompt Creating view V_DAO_CHARGE_ETUDE
prompt ================================
prompt
create or replace view v_dao_charge_etude as
select dc."DAC_CODE",dc."DAC_OBJET",dc."DAC_DTE_SAISI",dc."DAC_STA_CODE",dc."DAC_TYM_CODE",dc."DAC_MOP_CODE",dc."DAC_NBR_OUV",dc."DAC_GES_CODE",dc."DAC_FON_COD_AC",dc."DAC_STR_CODE",dc."DAC_FON_CODE_CPMP",dc."DAC_DTE_VAL_CPMP",dc."DAC_DTE_VAL_DMP",dc."DAC_TD_CODE",dc."DAC_DPP_ID",dc."DAC_DATE_RECEPTION",dc."DAC_STATUT_RETOUR",dc."DAC_MENTION",dcs.dcs_ope_matricule,dcs.dcs_pre_mbm,dcs.dcs_com_str_code,dcs.dcs_mbm_respo,dcs.dcs_fon_cod,tp.tdc_libelle,tym.tym_libelle_court,mop.mop_libelle_long
from t_dac_specs dc, t_commission_specifique cm, t_det_commission_seance dcs, t_type_dac_specs tp, t_type_marche tym, t_mode_passation mop
where dc.dac_code = cm.com_dac_code
and dc.dac_td_code = tp.tdc_code
and dc.dac_tym_code = tym.tym_code
and dc.dac_mop_code = mop.mop_code
and dcs.dcs_com_num = cm.com_num
/

prompt
prompt Creating view V_DAO_PIECES
prompt ==========================
prompt
create or replace view v_dao_pieces as
select  rownum V_Id,dc.dac_code,mdl.mdt_code,mdl.mdt_libelle_court,mdl.mdt_libelle_long
from t_dac_specs dc, t_modele_dac_type mdl, t_type_pieces_dac dt
where dc.dac_tym_code = mdl.mdt_tym_code
and mdl.mdt_code = dt.tpi_mdt_code
/

prompt
prompt Creating view V_DAO_STATUT
prompt ==========================
prompt
create or replace view v_dao_statut as
select hd.hac_sta_code,hd.hac_id,hd.hac_dac_code,hd.hac_date,hd.hac_commentaire,f.fon_libelle
from t_dac_specs dc, t_histo_dac hd, t_fonction f
where dc.dac_code = hd.hac_dac_code
and hd.hac_fon_cod = f.fon_cod
/

prompt
prompt Creating view V_DETAIL_ADRESSE
prompt ==============================
prompt
create or replace view v_detail_adresse as
select rownum as v_id, a.ada_fon_cod,a.ada_num, l.lia_libelle,d.dta_libelle from
t_adresse_avis a,t_libelle_adresse l,t_detail_adresse_avis d
where a.ada_num = d.dta_ada_num
and  l.lia_num = d.dta_lia_num
--and a.ada_fon_cod = 'FON-ACR30001'
--and a.ada_num  =5
/

prompt
prompt Creating view V_DETAIL_DAO
prompt ==========================
prompt
create or replace view v_detail_dao as
select dc."DAC_CODE",dc."DAC_OBJET",dc."DAC_DTE_SAISI",dc."DAC_STA_CODE",dc."DAC_TYM_CODE",dc."DAC_MOP_CODE",dc."DAC_NBR_OUV",dc."DAC_GES_CODE",dc."DAC_FON_COD_AC",dc."DAC_STR_CODE",dc."DAC_FON_CODE_CPMP",dc."DAC_DTE_VAL_CPMP",dc."DAC_DTE_VAL_DMP",dc."DAC_TD_CODE",dc."DAC_DPP_ID",dc."DAC_DATE_RECEPTION",dc."DAC_STATUT_RETOUR",  av."AAO_CODE",av."AAO_LIBELLE",av."AAO_DAC_CODE",av."AAO_DTE_SAISI",av."AAO_STA_CODE",av."AAO_DTE_PUB",av."AAO_DTE_OUV_TEC",av."AAO_DTE_HEUR_OUV",av."AAO_DTE_OUV_FIN",av."AAO_NBR_LOT",av."AAO_NBR_OUV",av."AAO_DELAI_VAL",av."AAO_FON_COD_AC",av."AAO_FON_CODE_CPMP",av."AAO_NAT_INT",av."AAO_TAUX",av."AAO_LIEU_EXE",av."AAO_NOM_RESP",av."AAO_INTER_PUB",av."AAO_CAUT_DEF_EXIG",av."AAO_BOMP_PUB",av."AAO_VENTE_PAR_LOT",av."AAO_AVIS_BAIL",av."AAO_MT_CAUT",av."AAO_MODE_PAIEMENT",av."AAO_COUT_DAC",av."AAO_LIEU_RECEP",av."AAO_DATE_RECEP",av."AAO_HEURE_RECEP",lt."LAA_ID",lt."LAA_AAO_CODE",lt."LAA_OBJET",lt."LAA_OBSERVATION",lt."LAA_MT_CAUT",lt."LAA_MT_EST",lt."LAA_DTE_SAISI",lt."LAA_STA_CODE",lt."LAA_FON_COD_SAISI",lt."LAA_FON_COD_CPMP",lt."LAA_LIEU_EXE",lt."LAA_LBG_IMPUTATION",lt."LAA_NUM",lt."LAA_COUT_LOT" , dos."DDA_ID",dos."DDA_NOM",dos."DDA_DTE_SAISI",dos."DDA_STA_CODE",dos."DDA_DAC_CODE",dos."DDA_PID_CODE",dos."DDA_REFERENCE",dos."DDA_COMMENTAIRE",tym.tym_libelle_court, mop.mop_libelle_long,st.str_code,st.str_libelle_court,st.str_libelle_long,min.min_libelle,pl.plp_ges_code
from t_dac_specs dc, t_avis_appel_offre av, t_lot_aao lt, t_dossier_dacs dos,t_type_marche tym, t_mode_passation mop, t_detail_plan_passation dp, t_ministere min, t_structure st, t_plan_passation pl
where dc.dac_code = av.aao_dac_code
and av.aao_code = lt.laa_aao_code
and dc.dac_code = dos.dda_dac_code
and dc.dac_mop_code = mop.mop_code
and dc.dac_tym_code = tym.tym_code
and dc.dac_code = dp.dpp_dac_code(+)
and dp.dpp_str_code = st.str_code
and min.min_code = st.str_min_code
and dp.dpp_plp_id = pl.plp_id
/

prompt
prompt Creating view V_DETAIL_ETAT
prompt ===========================
prompt
CREATE OR REPLACE VIEW V_DETAIL_ETAT AS
SELECT a.agp_id, c.tca_libelle, d.tda_titre,d.tda_commentaire,c.tca_code,d.tda_num_ordre
FROM t_agpm a,t_detail_agpm d,t_contenu_agpm c
where a.agp_id = d.tda_agp_id (+)
and d.tda_tca_code = c.tca_code (+)
--order by d.tda_num_ordre
group by a.agp_id, c.tca_code,c.tca_libelle, d.tda_titre,d.tda_commentaire,d.tda_num_ordre
/

prompt
prompt Creating view V_DET_PLANING
prompt ===========================
prompt
create or replace view v_det_planing as
select DPP_DATE_EXEC_FIN,
DPP_DATE_EXEC_DEBUT,
Fo_DateReg (DPP_DATE_AVIS_AO_PUBLICATION, '95A') DPP_DATE_MARCHE_APPROB,
Fo_DateReg (DPP_DATE_AVIS_AO_PUBLICATION, '71A') DPP_DATE_SIGNAT_AC,
Fo_DateReg (DPP_DATE_AVIS_AO_PUBLICATION, '68A') DPP_DATE_SIGNAT_ATTRIB,
DPP_DATE_NEGOCIATION,
DPP_DATE_ATT_APPRO_BAIL,
Fo_DateReg (DPP_DATE_AVIS_AO_PUBLICATION, '55A') DPP_DATE_ATT_APPROB_DMP,
Fo_DateReg (DPP_DATE_AVIS_AO_PUBLICATION, '45A') DPP_DATE_JUGEMENT_OFFRE,
DPP_DATE_ELAB_RAPPORT,
Fo_DateReg (DPP_DATE_AVIS_AO_PUBLICATION, '30A') DPP_DATE_OUVERT_OF,
Fo_DateReg (DPP_DATE_AVIS_AO_PUBLICATION, '30A') DPP_DATE_OUVERT_OT,
DPP_DATE_AVIS_AO_PUBLICATION,
DPP_DATE_DAO_APPROB_BAIL,
Fo_DateReg (DPP_DATE_DAO_TRANS , '5A') DPP_DATE_DAO_APPROB_DMP,
DPP_DATE_DAO_TRANS,
DPP_SOURCE_FIN,
DPP_OBJET,
DPP_DATE,
DPP_NUMERO_ORDRE,
DPP_CODE,
DPP_TYPE_PLAN,
DPP_LBG_CODE,
DPP_MOP_CODE,
DPP_TYM_CODE,
DPP_STA_CODE,
DPP_GPG_ID,
DPP_PLP_ID,
DPP_ID,
DPP_DATE_ATT_APPROB_CPMP,
DPP_INV_ENTRE,
DPP_DAC_CODE,
DPP_PIECE_DAO,
DPP_STATUT_DAO,
DPP_TYP_ID,
DPP_PARTIE_PME_PMI,
DPP_STRUCTURE_BENEFI,
DPP_STRUCTURE_CONDUC,
DPP_DATE_SAISIE,
DPP_STATUT_RETOUR,
DPP_STR_CODE,
DPP_ACTEUR_SAISIE,
Fo_DateReg (DPP_DATE_AVIS_AO_PUBLICATION, '45A') DPP_DATE_JUGEMENT_OFFRE_TEC from t_detail_plan_passation
/

prompt
prompt Creating view V_DOSSIER_AGPM
prompt ============================
prompt
create or replace view v_dossier_agpm as
select da."DAG_ID",da."DAG_NAP_CODE",da."DAG_AGP_ID",da."DAG_CODE",da."DAG_LIBELLE",da."DAG_COMMENTAIRE",da."DAG_REFERENCE"
from t_affichage_agpm ag, t_dossier_agpm da
where ag.aff_agp_id = da.dag_agp_id
/

prompt
prompt Creating view V_DOSSIER_PGPM
prompt ============================
prompt
create or replace view v_dossier_pgpm as
select dpl."DPG_ID",dpl."DPG_NAP_CODE",dpl."DPG_GPG_ID",dpl."DPG_CODE",dpl."DPG_LIBELLE",dpl."DPG_COMMENTAIRE",dpl."DPG_REFERENCE"
from t_affichage_pgpm pg, t_dossier_plan_general dpl
where pg.aff_gpg_plg_id = dpl.dpg_gpg_id
/

prompt
prompt Creating view V_FINANCEMENT
prompt ===========================
prompt
create or replace view v_financement as
select f.fin_id,f.fin_pro_id,f.fin_agp_id,f.fin_montant_cfa,f.fin_montant_devise,f.fin_numero_accord,f.fin_statut,b.bai_libelle,b.bai_telephone,b.bai_adresse,d.dev_libelle,d.dev_symbole,s.sou_libelle
from t_financement f, t_bailleur b, t_devise d, t_source_financement s
where f.fin_bai_code = b.bai_code
and f.fin_dev_code = d.dev_code(+)
and f.fin_sou_code = s.sou_code(+)
/

prompt
prompt Creating view V_FONCTION_ASSIGNATION
prompt ====================================
prompt
create or replace view v_fonction_assignation as
select f.FON_COD,f.FON_TYF_COD,f.FON_DAT_DEB,f.FON_DAT_FIN,f.FON_LIBELLE, ass.ass_ope_matricule
 from t_fonction f, t_assignation ass, t_operateur op where f.FON_COD NOT IN(select ASS_FON_COD FROM T_ASSIGNATION)
 AND op.ope_matricule = ass.ass_ope_matricule
/

prompt
prompt Creating view V_FONCTION_IMPUTATION
prompt ===================================
prompt
create or replace view v_fonction_imputation as
select m.OPE_MATRICULE, m.OPE_NOM,m.ope_contact ,m.fon_cod, m.FON_LIBELLE,m.str_code ,m.str_ope_respo, q.Nbr_traite, q.Nbr_en_Cours, q.Nbr_Valide from
(select  Nbr_traite, Nbr_en_Cours, Nbr_Valide, DCS_OPE_MATRICULE,DCS_OPE_MATRICULE2,DCS_OPE_MATRICULE3 from
(select t.DCS_OPE_MATRICULE DCS_OPE_MATRICULE, count(*) Nbr_traite from t_det_commission_seance t, t_dac_specs
where dac_code =t.DCS_DAC_CODE group by t.DCS_OPE_MATRICULE),--Nombre DAC recu
(select t.DCS_OPE_MATRICULE DCS_OPE_MATRICULE2, count(*) Nbr_en_Cours from t_det_commission_seance t, t_dac_specs
where dac_code =t.DCS_DAC_CODE and dac_sta_code ='D3A' group by t.DCS_OPE_MATRICULE),-- en cours de traitement
(select t.DCS_OPE_MATRICULE DCS_OPE_MATRICULE3, count(*) Nbr_Valide from t_det_commission_seance t, t_dac_specs
where dac_code =t.DCS_DAC_CODE and dac_sta_code ='D4V' group by t.DCS_OPE_MATRICULE )--   validé
) q,
(select  o.OPE_MATRICULE, o.OPE_NOM, o.ope_contact,s.str_code ,s.str_ope_respo, c.fon_cod ,c.FON_LIBELLE from t_fonction c, t_assignation a , t_type_fonction f, t_operateur o,t_structure s
where fon_cod =a.ASS_FON_COD
and a.ASS_OPE_MATRICULE=ope_matricule
and f.TYF_COD=fon_tyf_cod
and s.str_code=c.fon_str_code
and f.TYF_COD='CET')m
where M.OPE_MATRICULE=q.DCS_OPE_MATRICULE(+)
and M.OPE_MATRICULE= q.DCS_OPE_MATRICULE2(+)
and M.OPE_MATRICULE= q.DCS_OPE_MATRICULE3(+)
/

prompt
prompt Creating view V_FONCTION_MINISTERE
prompt ==================================
prompt
create or replace view v_fonction_ministere as
select f.fon_cod,f.fon_str_code,f.fon_libelle,f.fon_dat_deb,f.fon_dat_fin,f.fon_tel,f.fon_tyf_cod,tp.tyf_libelle,m.min_libelle,st.str_libelle_long
from  t_fonction f , t_ministere m, t_type_fonction tp, t_structure st
where f.fon_str_code = st.str_code
and m.min_code = st.str_min_code
and f.fon_tyf_cod = tp.tyf_cod
/

prompt
prompt Creating view V_HISTO_DAO
prompt =========================
prompt
create or replace view v_histo_dao as
select dc.dac_code, his."HAC_ID",his."HAC_FON_COD",his."HAC_OPE_MAT",his."HAC_DAC_CODE",his."HAC_STA_CODE",his."HAC_DATE",his."HAC_COMMENTAIRE"
from t_dac_specs dc,  t_histo_dac his
where dc.dac_code = his.hac_dac_code
/

prompt
prompt Creating view V_LIGNE_IMPUTATION
prompt ================================
prompt
create or replace view v_ligne_imputation as
select bud."LBG_CODE",bud."LBG_STR_CODE",bud."LBG_GES_CODE",bud."LBG_RES_DON",bud."LBG_IMPUTATION",bud."LBG_ANO_CODE",bud."LBG_NAT_CODE",bud."LBG_RES_TR",bud."LBG_DTE_SAISI",bud."LBG_AE_TR",bud."LBG_AE_DON",bud."LBG_AE_EMP",bud."LBG_MP",bud."LBG_REGL_MP",bud."LBG_TOT_DOT",bud."LBG_UTIL_SAISI",bud."LBG_DES_CODE",bud."LBG_DTE_MODIF",bud."LBG_RES_EMP",bud."LBG_RES_TOT",bud."LBG_UTIL_MODIF",bud."LBG_FON_CODE",bud."LBG_DIS_TRE",bud."LBG_DIS_DON",bud."LBG_DIS_EMP",bud."LBG_DIS_TOT",bud."LBG_FON_CODE_AC",bud."LBG_STA_CODE",bud."LBG_ACT_NUM_MODIF",bud."LBG_DTE_VAL",bud."LBG_FON_CODE_VAL",bud."LBG_TRAITMT",bud."LBG_TRAITMT_NOTIF",bud."LBG_DTE_STA_COUR",bud."LBG_TITRE",bud."LBG_COR",bud."LBG_ADM_CENTRAL",bud."LBG_MOTIF_COR",bud."LBG_DTE_COR",bud."LBG_FON_CODE_COR",bud."LBG_FON_CODE_PF",bud."LBG_FON_CODE_VAL_ACT",bud."LBG_ACTIF",bud."LBG_FON_CODE_CF",bud."LBG_DOT_AN_PLUS1",bud."LBG_DOT_AN_PLUS2",bud."LBG_DOT_AN_PLUS0",bud."LBG_TYP_BUD",bud."LBG_DTE_MP",bud."LBG_UTIL_SAISI_ACT",bud."LBG_SIGFIP",bud."LBG_FON_CODE_PR",bud."LBG_FON_CODE_VEROU",na.nat_libelle 
from t_l_budgets bud, t_natures na
where bud.lbg_nat_code = na.nat_code
/

prompt
prompt Creating view V_PGPM_FONCTION
prompt =============================
prompt
create or replace view v_pgpm_fonction as
select dp."GPG_ID",dp."GPG_PLG_ID",dp."GPG_AGP_ID",dp."GPG_TYPE_PLAN",dp."GPG_STA_CODE",dp."GPG_TYM_CODE",dp."GPG_MOP_CODE",dp."GPG_CODE",dp."GPG_OBJET",dp."GPG_NUMERO_ORDRE",dp."GPG_PARTIE_PME_PMI",dp."GPG_COMMENTAIRE",dp."GPG_SOURCE_FIN",dp."GPG_DATE_DAO",dp."GPG_ACTEUR_SAISIE",dp."GPG_STATUT_RETOUR",dp."GPG_DATE_SAISIE",dp."GPG_STR_CODE" ,tym.tym_libelle_court,tym.tym_tym_code, mop.mop_libelle_long, pl.plg_fon_cod,f.fon_libelle
from t_plan_general pl, t_detail_plan_general dp, t_fonction f,t_mode_passation mop, t_type_marche tym
where pl.plg_id = dp.gpg_plg_id
and pl.plg_fon_cod = f.fon_cod
and dp.gpg_mop_code = mop.mop_code
and dp.gpg_tym_code = tym.tym_code
/

prompt
prompt Creating view V_MODELE_DAO
prompt ==========================
prompt
create or replace view v_modele_dao as
select rownum V_Id,vp.gpg_id,md.mdt_code, md.mdt_libelle_court, md.mdt_libelle_long, md.mdt_tym_code from v_pgpm_fonction vp, t_modele_dac_type md
where vp.tym_tym_code = md.mdt_tym_code
/

prompt
prompt Creating view V_PGPM
prompt ====================
prompt
create or replace view v_pgpm as
select DISTINCT dpg.gpg_id,sf.sou_libelle, dpg.gpg_objet, dpg.gpg_sta_code, dpg.gpg_acteur_saisie, f.fon_libelle,tym.tym_code ,tym.tym_libelle_court, mop.mop_code, mop.mop_libelle_court, mop.mop_libelle_long, dpg.gpg_partie_pme_pmi,dpg.gpg_date_dao,dpg.gpg_commentaire,dpg.gpg_numero_ordre,dpg.gpg_date_saisie,pl.plg_id,pl.plg_ges_code,m.min_libelle,m.min_libelle_court,st.str_code,st.str_libelle_court,st.str_libelle_long 
from t_detail_plan_general dpg, t_financement_pgpm fip, t_source_financement sf, t_plan_general pl ,t_fonction f, t_type_marche tym, t_mode_passation mop, t_ministere m, t_structure st
where dpg.gpg_id = fip.fip_gpg_id(+)
and fip.fip_sou_code = sf.sou_code
and pl.plg_fon_cod = f.fon_cod
and dpg.gpg_tym_code = tym.tym_code
and dpg.gpg_mop_code = mop.mop_code
and pl.plg_str_code = st.str_code
and m.min_code = st.str_min_code
/

prompt
prompt Creating view V_PGPM_DETAILS
prompt ============================
prompt
create or replace view v_pgpm_details as
select DISTINCT afp.aff_gpg_id,sf.sou_libelle,afp.aff_gpg_objet,afp.aff_gpg_sta_code,afp.aff_gpg_type_plan,afp.aff_gpg_acteur_saisie, f.fon_libelle,tym.tym_code ,tym.tym_libelle_court, mop.mop_code, mop.mop_libelle_court, mop.mop_libelle_long,afp.aff_gpg_partie_pme_pmi,afp.aff_gpg_date_dao,afp.aff_gpg_commentaire,afp.aff_gpg_numero_ordre,afp.aff_gpg_date_saisie,pl.plg_id,pl.plg_ges_code,m.min_libelle,m.min_libelle_court,st.str_code,st.str_libelle_court,st.str_libelle_long
from t_affichage_pgpm afp, t_financement_pgpm fip, t_source_financement sf, t_plan_general pl ,t_fonction f, t_type_marche tym, t_mode_passation mop, t_ministere m, t_structure st
where afp.aff_gpg_id = fip.fip_gpg_id(+)
and fip.fip_sou_code = sf.sou_code(+)
and pl.plg_fon_cod = f.fon_cod
and afp.aff_gpg_tym_code = tym.tym_code
and afp.aff_gpg_mop_code = mop.mop_code
and pl.plg_str_code = st.str_code
and m.min_code = st.str_min_code
/

prompt
prompt Creating view V_PGPM_STATUT
prompt ===========================
prompt
create or replace view v_pgpm_statut as
select hpl.hpg_id,hpl.hpg_date,hpl.hpg_motif,hpl.hpg_sta_code,hpl.hpg_gpg_id,hpl.hpg_fon_cod,f.fon_libelle 
from t_detail_plan_general dpl, t_histo_plan_general hpl, t_fonction f
where hpl.hpg_gpg_id = dpl.gpg_id
and hpl.hpg_fon_cod =f.fon_cod
/

prompt
prompt Creating view V_PPM_DAO
prompt =======================
prompt
create or replace view v_ppm_dao as
select pas."DPP_ID",pas."DPP_PLP_ID",pas."DPP_GPG_ID",pas."DPP_STA_CODE",pas."DPP_TYM_CODE",pas."DPP_MOP_CODE",pas."DPP_LBG_CODE",pas."DPP_TYPE_PLAN",pas."DPP_CODE",pas."DPP_NUMERO_ORDRE",pas."DPP_DATE",pas."DPP_OBJET",pas."DPP_SOURCE_FIN",pas."DPP_DATE_DAO_TRANS",pas."DPP_DATE_DAO_APPROB_DMP",pas."DPP_DATE_DAO_APPROB_BAIL",pas."DPP_DATE_AVIS_AO_PUBLICATION",pas."DPP_DATE_OUVERT_OT",pas."DPP_DATE_OUVERT_OF",pas."DPP_DATE_ELAB_RAPPORT",pas."DPP_DATE_JUGEMENT_OFFRE",pas."DPP_DATE_ATT_APPROB_DMP",pas."DPP_DATE_ATT_APPRO_BAIL",pas."DPP_DATE_NEGOCIATION",pas."DPP_DATE_SIGNAT_ATTRIB",pas."DPP_DATE_SIGNAT_AC",pas."DPP_DATE_MARCHE_APPROB",pas."DPP_DATE_EXEC_DEBUT",pas."DPP_DATE_EXEC_FIN",pas."DPP_ACTEUR_SAISIE",pas."DPP_STR_CODE",pas."DPP_STATUT_RETOUR",pas."DPP_DATE_SAISIE",pas."DPP_STRUCTURE_CONDUC",pas."DPP_STRUCTURE_BENEFI",pas."DPP_PARTIE_PME_PMI",pas."DPP_TYP_ID",pas."DPP_STATUT_DAO",pas."DPP_PIECE_DAO",pas."DPP_DAC_CODE", mdl.mdt_code,mdl.mdt_tym_code,mdl.mdt_libelle_court,tym.tym_code, tym.tym_libelle_court,mop.mop_code ,mop.mop_libelle_long,leb.lbg_imputation,nat.nat_libelle, sf.sou_libelle
from t_detail_plan_passation pas, t_modele_dac_type mdl, t_type_marche tym, t_mode_passation mop, t_l_budgets leb,t_natures nat,t_source_financement sf
where pas.dpp_mop_code = mop.mop_code
and pas.dpp_tym_code = tym.tym_code
and pas.dpp_piece_dao = mdl.mdt_code
and pas.dpp_lbg_code = leb.lbg_code
and leb.lbg_nat_code = nat.nat_code
and pas.dpp_source_fin = sf.sou_code
/

prompt
prompt Creating view V_PPM_DETAILS
prompt ===========================
prompt
create or replace view v_ppm_details as
select dp."DPP_ID",dp."DPP_PLP_ID",dp."DPP_GPG_ID",dp."DPP_STA_CODE",dp."DPP_TYM_CODE",dp."DPP_MOP_CODE",dp."DPP_LBG_CODE",dp."DPP_TYPE_PLAN",dp."DPP_CODE",dp."DPP_NUMERO_ORDRE",dp."DPP_DATE",dp."DPP_OBJET",dp."DPP_SOURCE_FIN",dp."DPP_DATE_DAO_TRANS",dp."DPP_DATE_DAO_APPROB_DMP",dp."DPP_DATE_DAO_APPROB_BAIL",dp."DPP_DATE_AVIS_AO_PUBLICATION",dp."DPP_DATE_OUVERT_OT",dp."DPP_DATE_OUVERT_OF",dp."DPP_DATE_ELAB_RAPPORT",dp."DPP_DATE_JUGEMENT_OFFRE",dp."DPP_DATE_ATT_APPROB_DMP",dp."DPP_DATE_ATT_APPRO_BAIL",dp."DPP_DATE_NEGOCIATION",dp."DPP_DATE_SIGNAT_ATTRIB",dp."DPP_DATE_SIGNAT_AC",dp."DPP_DATE_MARCHE_APPROB",dp."DPP_DATE_EXEC_DEBUT",dp."DPP_DATE_EXEC_FIN",pl.plp_ges_code,dp.dpp_date_saisie,dp.dpp_typ_id,pl.plp_libelle,dpl.gpg_objet,c.chr_commentaire, st.str_libelle_long, st.str_libelle_court,st.str_email,tym.tym_code,tym.tym_libelle_court,tym.tym_libelle_long,tym.tym_tym_code,mop.mop_code,mop.mop_libelle_court,mop.mop_libelle_long,lib."LBG_CODE",lib."LBG_STR_CODE",lib."LBG_GES_CODE",lib."LBG_RES_DON",lib."LBG_IMPUTATION",lib."LBG_ANO_CODE",lib."LBG_NAT_CODE",lib."LBG_RES_TR",lib."LBG_DTE_SAISI",lib."LBG_AE_TR",lib."LBG_AE_DON",lib."LBG_AE_EMP",lib."LBG_MP",lib."LBG_REGL_MP",lib."LBG_TOT_DOT",lib."LBG_UTIL_SAISI",lib."LBG_DES_CODE",lib."LBG_DTE_MODIF",lib."LBG_RES_EMP",lib."LBG_RES_TOT",lib."LBG_UTIL_MODIF",lib."LBG_FON_CODE",lib."LBG_DIS_TRE",lib."LBG_DIS_DON",lib."LBG_DIS_EMP",lib."LBG_DIS_TOT",lib."LBG_FON_CODE_AC",lib."LBG_STA_CODE",lib."LBG_ACT_NUM_MODIF",lib."LBG_DTE_VAL",lib."LBG_FON_CODE_VAL",lib."LBG_TRAITMT",lib."LBG_TRAITMT_NOTIF",lib."LBG_DTE_STA_COUR",lib."LBG_TITRE",lib."LBG_COR",lib."LBG_ADM_CENTRAL",lib."LBG_MOTIF_COR",lib."LBG_DTE_COR",lib."LBG_FON_CODE_COR",lib."LBG_FON_CODE_PF",lib."LBG_FON_CODE_VAL_ACT",lib."LBG_ACTIF",lib."LBG_FON_CODE_CF",lib."LBG_DOT_AN_PLUS1",lib."LBG_DOT_AN_PLUS2",lib."LBG_DOT_AN_PLUS0",lib."LBG_TYP_BUD",lib."LBG_DTE_MP",lib."LBG_UTIL_SAISI_ACT",lib."LBG_SIGFIP",lib."LBG_FON_CODE_PR",lib."LBG_FON_CODE_VEROU",pm.fpp_montant_cfa,pm.fpp_montant_devise,pm.fpp_commentaire,ba.bai_libelle,dv.dev_libelle,dv.dev_symbole,m.min_libelle
from t_plan_passation pl, t_detail_plan_passation dp, t_histo_plan_passation hi, t_detail_plan_general dpl, t_charge c, t_structure st, t_type_marche tym, t_mode_passation mop, t_l_budgets lib, t_financement_ppm pm, t_fonction f, t_ministere m,t_bailleur ba, t_devise dv, t_source_financement sf, t_type_procedure pc 
where pl.plp_id = dp.dpp_plp_id
and dp.dpp_tym_code = tym.tym_code 
and dp.dpp_mop_code = mop.mop_code
and dp.dpp_lbg_code = lib.lbg_code 
and dp.dpp_id = pm.fpp_dpp_id(+)
and pl.plp_fon_cod = f.fon_cod
and dp.dpp_id = c.chr_dpp_id(+)
and c.chr_str_code = st.str_code(+)
and pl.plp_str_code = st.str_code
and m.min_code = st.str_min_code
and pm.fpp_bai_code = ba.bai_code(+)
and pm.fpp_dev_code = dv.dev_code(+)
and pm.fpp_sou_code = sf.sou_code(+)
and dp.dpp_typ_id = pc.typ_id(+)
/

prompt
prompt Creating view V_PPM_ETAT
prompt ========================
prompt
create or replace view v_ppm_etat as
select  rownum V_Id,dp.aff_id,dp.aff_dpp_id, f.fon_libelle,dp.aff_dpp_objet,dp.aff_dpp_source_fin,leb.lbg_code,leb.lbg_imputation,nat.nat_code,nat.nat_libelle,tym.tym_libelle_court,mop.mop_libelle_long,dp.aff_dpp_date_avis_ao_publicat,dp.aff_dpp_date_ouvert_ot,dp.aff_dpp_date_ouvert_of,dp.aff_dpp_date_jugement_offre,dp.aff_dpp_date_att_approb_dmp,dp.aff_dpp_date_att_appro_bail,dp.aff_dpp_plp_id,dp.aff_dpp_str_benefi,dp.aff_dpp_str_conduc,dp.aff_dpp_type_plan,dp.aff_dpp_date_negociation,dp.aff_dpp_date_elab_rapport,dp.aff_dpp_date_signat_attrib,dp.aff_dpp_date_signat_ac,dp.aff_dpp_date_exec_debut,dp.aff_dpp_date_exec_fin,dp.aff_dpp_date_dao_trans,dp.aff_dpp_date_dao_approb_dmp,dp.aff_dpp_date_dao_approb_bail,dp.aff_dpp_inv_entre
from t_affichage_ppm dp,t_fonction f, t_plan_passation pas, t_l_budgets leb, t_natures nat, t_type_marche tym, t_mode_passation mop
where dp.aff_dpp_plp_id = pas.plp_id
and dp.aff_dpp_lbg_code = leb.lbg_code
and leb.lbg_nat_code = nat.nat_code
and dp.aff_dpp_tym_code = tym.tym_code
and dp.aff_dpp_mop_code =mop.mop_code
and dp.aff_dpp_fon_cod = f.fon_cod
/

prompt
prompt Creating view V_PPM_STATUT
prompt ==========================
prompt
create or replace view v_ppm_statut as
select hp.hpp_sta_code,hp.hpp_dpp_id,hp.hpp_id,hp.hpp_date,hp.hpp_motif,f.fon_libelle
from t_detail_plan_passation pa, t_histo_plan_passation hp, t_fonction f
where pa.dpp_id = hp.hpp_dpp_id
and hp.hpp_fon_cod = f.fon_cod
/

prompt
prompt Creating view V_PROJET_AGPM
prompt ===========================
prompt
create or replace view v_projet_agpm as
select pr.pro_id,pr.pro_titre,pr.pro_type_projet,ag.agp_type_dao,ag.agp_sta_code,ag.agp_actif,pr.pro_montant_tot_cfa,pr.pro_description,ag.agp_id,ag.agp_dec_id,ag.agp_mode_passation,ag.agp_ges_code,ag.agp_commentaire,ag.agp_str_code,ag.agp_acteur_saisie,rg.reg_id,rg.reg_libelle_long,rg.reg_libelle_court,m.min_libelle,m.min_libelle_court,ba.bai_libelle,dev.dev_libelle,sf.sou_libelle,fin.fin_numero_accord,fin.fin_montant_cfa,fin.fin_montant_devise,f.fon_libelle,st.str_code,st.str_libelle_court,st.str_libelle_long
from t_projet pr, t_agpm ag, t_reglementation rg, t_fonction f, t_ministere m, t_structure st, t_financement fin, t_bailleur ba, t_devise dev, t_source_financement sf
where ag.agp_pro_id = pr.pro_id
and pr.pro_reg_id = rg.reg_id (+)
and ag.agp_fon_cod = f.fon_cod (+)
and ag.agp_str_code = st.str_code(+)
and m.min_code = st.str_min_code
and ag.agp_id = fin.fin_agp_id
and pr.pro_id = fin.fin_pro_id
and fin.fin_bai_code = ba.bai_code
and fin.fin_dev_code = dev.dev_code
and fin.fin_sou_code = sf.sou_code
/

prompt
prompt Creating view V_PSPM_DETAILS
prompt ============================
prompt
create or replace view v_pspm_details as
select dp."AFF_DPP_ID",dp."AFF_DPP_PLP_ID",dp."AFF_DPP_GPG_ID",dp."AFF_DPP_STA_CODE",dp."AFF_DPP_TYM_CODE",dp."AFF_DPP_MOP_CODE",dp."AFF_DPP_LBG_CODE",dp."AFF_DPP_TYPE_PLAN",dp."AFF_DPP_CODE",dp."AFF_DPP_NUMERO_ORDRE",dp."AFF_DPP_DATE",dp."AFF_DPP_OBJET",dp."AFF_DPP_SOURCE_FIN",dp."AFF_DPP_DATE_DAO_TRANS",dp."AFF_DPP_DATE_DAO_APPROB_DMP",dp."AFF_DPP_DATE_DAO_APPROB_BAIL",dp."AFF_DPP_DATE_AVIS_AO_PUBLICAT",dp."AFF_DPP_DATE_OUVERT_OT",dp."AFF_DPP_DATE_OUVERT_OF",dp."AFF_DPP_DATE_ELAB_RAPPORT",dp."AFF_DPP_DATE_JUGEMENT_OFFRE",dp."AFF_DPP_DATE_ATT_APPROB_DMP",dp."AFF_DPP_DATE_ATT_APPRO_BAIL",dp."AFF_DPP_DATE_NEGOCIATION",dp."AFF_DPP_DATE_SIGNAT_ATTRIB",dp."AFF_DPP_DATE_SIGNAT_AC",dp."AFF_DPP_DATE_MARCHE_APPROB",dp."AFF_DPP_DATE_EXEC_DEBUT",dp."AFF_DPP_DATE_EXEC_FIN",pl.plp_ges_code,dp.aff_dpp_date_saisie,pl.plp_libelle,dpl.gpg_objet,c.chr_commentaire, st.str_libelle_long, st.str_libelle_court,st.str_email,tym.tym_code,tym.tym_libelle_court,tym.tym_libelle_long,mop.mop_code,mop.mop_libelle_court,mop.mop_libelle_long,lib."LBG_CODE",lib."LBG_STR_CODE",lib."LBG_GES_CODE",lib."LBG_RES_DON",lib."LBG_IMPUTATION",lib."LBG_ANO_CODE",lib."LBG_NAT_CODE",lib."LBG_RES_TR",lib."LBG_DTE_SAISI",lib."LBG_AE_TR",lib."LBG_AE_DON",lib."LBG_AE_EMP",lib."LBG_MP",lib."LBG_REGL_MP",lib."LBG_TOT_DOT",lib."LBG_UTIL_SAISI",lib."LBG_DES_CODE",lib."LBG_DTE_MODIF",lib."LBG_RES_EMP",lib."LBG_RES_TOT",lib."LBG_UTIL_MODIF",lib."LBG_FON_CODE",lib."LBG_DIS_TRE",lib."LBG_DIS_DON",lib."LBG_DIS_EMP",lib."LBG_DIS_TOT",lib."LBG_FON_CODE_AC",lib."LBG_STA_CODE",lib."LBG_ACT_NUM_MODIF",lib."LBG_DTE_VAL",lib."LBG_FON_CODE_VAL",lib."LBG_TRAITMT",lib."LBG_TRAITMT_NOTIF",lib."LBG_DTE_STA_COUR",lib."LBG_TITRE",lib."LBG_COR",lib."LBG_ADM_CENTRAL",lib."LBG_MOTIF_COR",lib."LBG_DTE_COR",lib."LBG_FON_CODE_COR",lib."LBG_FON_CODE_PF",lib."LBG_FON_CODE_VAL_ACT",lib."LBG_ACTIF",lib."LBG_FON_CODE_CF",lib."LBG_DOT_AN_PLUS1",lib."LBG_DOT_AN_PLUS2",lib."LBG_DOT_AN_PLUS0",lib."LBG_TYP_BUD",lib."LBG_DTE_MP",lib."LBG_UTIL_SAISI_ACT",lib."LBG_SIGFIP",lib."LBG_FON_CODE_PR",lib."LBG_FON_CODE_VEROU",pm.fpp_montant_cfa,pm.fpp_montant_devise,pm.fpp_commentaire,ba.bai_libelle,dv.dev_libelle,dv.dev_symbole,m.min_libelle,dp.aff_dpp_str_conduc,dp.aff_dpp_str_benefi
from t_plan_passation pl, t_affichage_ppm dp, t_detail_plan_general dpl, t_charge c, 
t_structure st, t_type_marche tym, t_mode_passation mop, t_l_budgets lib, t_financement_ppm pm, t_fonction f, t_ministere m,t_bailleur ba, t_devise dv, t_source_financement sf
where --pl.plp_id = dp.dpp_plp_id
 pl.plp_id = dp.aff_dpp_plp_id
and dp.aff_dpp_tym_code = tym.tym_code
and dp.aff_dpp_mop_code = mop.mop_code
--and dp.dpp_liae_num = lib.liae_num
and dp.aff_dpp_lbg_code = lib.lbg_code
and dp.aff_dpp_id = pm.fpp_dpp_id(+)
and pl.plp_fon_cod = f.fon_cod
and dp.aff_dpp_gpg_id = dpl.gpg_id
--and dp.dpp_id = c.chr_dpp_id(+)
and dp.aff_dpp_id = c.chr_dpp_id(+)
and c.chr_str_code = st.str_code(+)
and pl.plp_str_code = st.str_code
and st.str_min_code = m.min_code
and pm.fpp_bai_code = ba.bai_code(+)
and pm.fpp_dev_code = dv.dev_code(+)
and pm.fpp_sou_code = sf.sou_code(+)
and dp.aff_dpp_type_plan = 'PS'
/

prompt
prompt Creating view V_STRUCTURE_CHARGE
prompt ================================
prompt
create or replace view v_structure_charge as
select ch.chr_id, st.str_libelle_long, tyc.tyc_libelle_long
from t_charge ch, t_type_charge tyc, t_structure st
where ch.chr_str_code = st.str_code
and ch.chr_tyc_code = tyc.tyc_code
/

prompt
prompt Creating view V_TYPE_MARCHE_FILS
prompt ================================
prompt
create or replace view v_type_marche_fils as
select TYM_CODE,TYM_LIBELLE_COURT, TYM_LIBELLE_LONG, TYM_TYM_CODE from vb_type_marche  where TYM_TYM_CODE is not null
/

prompt
prompt Creating function FB_EXISTE_CORRECTION
prompt ======================================
prompt
create or replace function Fb_Existe_Correction(V_COR_DAC_CODE IN Vb_Correction_Dac.COR_DAC_CODE%TYPE,
                                                V_COR_NUM OUT Vb_Correction_Dac.COR_NUM%Type)
                                                return number is
  Cursor Rech IS Select t.COR_NUM from Vb_Correction_Dac t where t.COR_DAC_CODE=V_COR_DAC_CODE;
  Result number;
  test Rech%rowtype;

begin

  OPEN Rech ;
  FETCH Rech Into test;
    IF test.cor_num is  null THEN
        Result:=0;
        V_COR_NUM:=Seq_Cor_Num.Nextval; 
    ELSE
        Result:=1;
        FETCH Rech INTO V_COR_NUM;
    END IF;
  CLOSE Rech;
  return(Result);
end Fb_Existe_Correction;
/

prompt
prompt Creating function FO_ISNUMERIC
prompt ==============================
prompt
CREATE OR REPLACE FUNCTION FO_ISNUMERIC (val in varchar2) RETURN number
 IS
 nb number;
BEGIN
  nb:=to_number(val);
  return 1;
exception
	 when others then
	    return 0;
END;
/

prompt
prompt Creating function FO_DATEREG
prompt ============================
prompt
CREATE OR REPLACE FUNCTION FO_DATEREG (P_Du in Date, VMode_Jour in varchar2)
return date is
  Resultat date:=P_du;
  Compteur number:=0;
  Sens number:=1; -- direction +/-
  k number:=0; -- ajustement
  Passe number:=0; --- saute les jours non conformes
  ValDelaiReg varchar2(30):=replace(replace(replace(replace(VMode_Jour,'F'),'C'),'A'),'E');
  DelaiReg number;
  TmpMode varchar2(30):=replace(VMode_Jour,ValDelaiReg);
  -- F : Jours Francs ex : 20F ->20
  -- C : Jours calendaires : 20C ->20
  -- A : Jours Ouvrables : 20A ->20
  -- E : Jours Ouvrés : 20E ->20
begin
if Resultat is not null then
 DelaiReg:=to_number(case when fo_isnumeric(ValDelaiReg)=1 then ValDelaiReg else '0' end);
 if DelaiReg < 0 then
     Sens := - 1;  --
     DelaiReg := abs(DelaiReg);
 end if;
 if instr(VMode_Jour,ValDelaiReg)=1 and instr(VMode_Jour,TmpMode)>1 and length(TmpMode)<=2 and DelaiReg>0 then
  while Compteur < DelaiReg loop
     Resultat := Resultat + Sens;
       if instr(TmpMode,'E')>0 then -- ouvrés
          if to_char( Resultat, 'D') in(1,2,3,4,5) then
             Compteur := Compteur + 1;
          else
             Passe := Passe + 1;
          end if;
       elsif instr(TmpMode,'A')>0 then -- ouvrables
          if to_char( Resultat, 'D') in(1,2,3,4,5,6) then
             Compteur := Compteur + 1;
          else
             Passe := Passe + 1;
          end if;
       elsif instr('CCFFC',TmpMode)>0 then -- calendaires / francs
             Compteur := Compteur + 1;
       end if;
   end loop;
    if instr(TmpMode,'F')>0 then -- francs
       k:=1;
    end if;
    Resultat:=P_Du + (Sens * (Compteur + Passe))+ k * Sens;
 end if;
end if;
return resultat;
end FO_DateReg;
/

prompt
prompt Creating trigger TRIG_GEN_DATE_REGL
prompt ===================================
prompt
create or replace trigger TRIG_GEN_DATE_REGL
  before insert on t_detail_plan_passation  
 FOR EACH ROW 

begin
  
 
:new.DPP_DATE_DAO_APPROB_DMP:=Fo_DateReg (:new.DPP_DATE_DAO_TRANS , '5A');
--:new.DPP_DATE_DAO_APPROB_DMP:=Fo_DateReg (:Vb_Detail_Ppm.Dpm_Dte_Pub_Aao, '30A');
:new.DPP_DATE_OUVERT_OF:=Fo_DateReg (:new.DPP_DATE_AVIS_AO_PUBLICATION, '30A');
:new.DPP_DATE_OUVERT_OF:=Fo_DateReg (:new.DPP_DATE_AVIS_AO_PUBLICATION, '30A');
:new.DPP_DATE_JUGEMENT_OFFRE:=Fo_DateReg (:new.DPP_DATE_AVIS_AO_PUBLICATION, '45A');
:new.DPP_DATE_JUGEMENT_OFFRE_TEC:=Fo_DateReg (:new.DPP_DATE_AVIS_AO_PUBLICATION, '45A');
:new.DPP_DATE_ATT_APPROB_DMP:=Fo_DateReg (:new.DPP_DATE_AVIS_AO_PUBLICATION, '55A');
:new.DPP_DATE_SIGNAT_ATTRIB :=Fo_DateReg (:new.DPP_DATE_AVIS_AO_PUBLICATION, '68A');
:new.DPP_DATE_SIGNAT_ATTRIB :=Fo_DateReg (:new.DPP_DATE_AVIS_AO_PUBLICATION, '71A');
:new.DPP_DATE_MARCHE_APPROB:=Fo_DateReg (:new.DPP_DATE_AVIS_AO_PUBLICATION, '95A');

end TRIG_GEN_DATE_REGL;
/

prompt
prompt Creating trigger TRIG_INS_T_TEMP_PARAMETRE
prompt ==========================================
prompt
CREATE OR REPLACE TRIGGER "TRIG_INS_T_TEMP_PARAMETRE"
BEFORE INSERT ON T_TEMP_PARAMETRE
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW

Begin
select seq_temp_parametre.nextval into :new.TEMP_NUM from dual;

IF :new.TEMP_TYPE ='LOT' THEN 
----Si l'enregistrement concerne des lots--------- 
insert into t_lot_aao(laa_num,
                      laa_aao_code,
                      laa_objet,
                      laa_mt_caut,
                      laa_lbg_imputation,
                      laa_cout_lot,
                      laa_ope_matricule,
                      laa_dte_saisi, 
                      laa_dac_code
                      )
    select k.cpt laa_num,
           :new.TEMP_CHAMP_08 laa_aao_code,
           nvl(:new.TEMP_CHAMP_04,'Lot')||' '||to_char(k.cpt) laa_objet,
           to_number(:new.TEMP_CHAMP_06) laa_mt_caut,
           :new.TEMP_CHAMP_05 laa_lbg_imputation,
           to_number(:new.TEMP_CHAMP_07) laa_cout_lot,
           :new.TEMP_OPE_MATRICULE laa_ope_matricule,
           sysdate, 
           :new.TEMP_CHAMP_08
     from (select q.cpt from
                        (select level cpt from dual
                         connect by level<=1024
                         ) q
          where q.cpt >=greatest(1,nvl(to_number(:new.TEMP_CHAMP_02),0)) and q.cpt<=least(nvl(to_number(:new.TEMP_CHAMP_01),0),nvl(to_number(:new.TEMP_CHAMP_03),1024))
            and q.cpt not in (select t.LAA_NUM from t_lot_aao t where t.laa_aao_code=:new.TEMP_CHAMP_08)
        )k
    ;
    
 ELSIF :new.TEMP_TYPE ='DAC_CORRECTION' THEN 
----Si l'enregistrement concerne la correction des dac--------- 
        IF  fb_existe_correction(:new.TEMP_CHAMP_04,:new.TEMP_CHAMP_07) =0 THEN
        
        ----Insertion dans t_correction_dac si le DAO n'en possède pas ----
              Insert Into vb_correction_dac 
                      (COR_DAC_CODE,
                      COR_LIEBLLE,
                      COR_DTE_SAISI,
                      COR_OPE_MATRICULE,
                      COR_NUM)
              values (:new.TEMP_CHAMP_04,
                     'CORRECTION DU DOSSIER D''APPEL D''OFFRES '||:new.TEMP_CHAMP_04,
                     SYSDATE,
                     :new.TEMP_OPE_MATRICULE,
                     :new.TEMP_CHAMP_07); 
        END IF; 
     -- Insertion dans détail correction --------  
     Insert Into vb_detail_correction (DCO_TITRE,DCO_LIBELLE,DCO_DTE_SAISI,DCO_PID_CODE,DCO_DAC_CODE,DCO_FON_COD_SAISI,DCO_OPE_MATRICULE,DCO_OBSERVATION, DCO_COR_NUM)
     values (:new.TEMP_CHAMP_01,
       :new.TEMP_CHAMP_02,
       SYSDATE,
       to_number(:new.TEMP_CHAMP_03),
       :new.TEMP_CHAMP_04,
       :new.TEMP_CHAMP_05,
       :new.TEMP_OPE_MATRICULE,
       :new.TEMP_CHAMP_06, 
       :new.TEMP_CHAMP_07);
END IF;

 end;
/

prompt
prompt Creating trigger TRIG_T_DETAIL_CORRECTION
prompt =========================================
prompt
CREATE OR REPLACE TRIGGER "TRIG_T_DETAIL_CORRECTION"
BEFORE INSERT ON EMAP.T_DETAIL_CORRECTION
FOR EACH ROW

Begin
 select Seq_T_Detail_Correction.nextval into :new.DCO_NUM from dual;
end;
/

prompt
prompt Creating trigger TRIG_T_LOT_AAO
prompt ===============================
prompt
CREATE OR REPLACE TRIGGER "TRIG_T_LOT_AAO"
BEFORE INSERT ON EMAP.T_LOT_AAO
FOR EACH ROW

Begin
 select seq_t_lot_aao.nextval into :new.LAA_ID from dual;
end;
/


spool off

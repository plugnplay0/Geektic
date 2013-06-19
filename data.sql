-- TABLE TYPE ---------------------------------
----- Type 'flag' pour les listes de Accueil --
INSERT INTO TYPE VALUES (0, '');
----- Autres types d'intérêt ------------------
INSERT INTO TYPE VALUES (1, 'JEUX');
INSERT INTO TYPE VALUES (2, 'OS');
INSERT INTO TYPE VALUES (3, 'LANGAGES');
-----------------------------------------------


-- TABLE INTERET ---------------------------------------
----- Interet 'flag' pour les listes de Accueil --------
INSERT INTO INTERET VALUES (0, 0, '--- (ignorer) ---');
----- Autres intérêts ----------------------------------
INSERT INTO INTERET VALUES (1, 1, 'League of Legends');
INSERT INTO INTERET VALUES (2, 1, 'World of Warcraft');
INSERT INTO INTERET VALUES (3, 1, 'Portal');
INSERT INTO INTERET VALUES (4, 1, 'Diablo');
INSERT INTO INTERET VALUES (5, 2, 'Windows');
INSERT INTO INTERET VALUES (6, 2, 'Macintosh');
INSERT INTO INTERET VALUES (7, 2, 'Linux');
INSERT INTO INTERET VALUES (8, 3, 'Java');
INSERT INTO INTERET VALUES (9, 3, 'C#.NET');
INSERT INTO INTERET VALUES (10, 3, 'C');
INSERT INTO INTERET VALUES (11, 3, 'C++');
INSERT INTO INTERET VALUES (12, 3, 'JavaScript');
INSERT INTO INTERET VALUES (13, 3, 'PHP');
--------------------------------------------------------


-- TABLE GEEK ------------------------------------------------------------------------------------------------------
----- Geek 'flag' --------------------------------------------------------------------------------------------------
INSERT INTO GEEK VALUES (0, 'inexistant', 'inexistant', 'inexistant', '-', 'inexistant', '1900-01-01', 0);
----- Autres geeks -------------------------------------------------------------------------------------------------
INSERT INTO GEEK VALUES (1, 'legeek01', 'LE', 'Geek', 'h', 'legeek01@hotmail.com', '1989-01-01', 0);
INSERT INTO GEEK VALUES (2, 'tourbilol', 'GAREN', 'Garen', 'h', 'tourbilol@gmail.com', '1975-02-02', 0);
INSERT INTO GEEK VALUES (3, 'cowcow', 'FIDDLE', 'Stick', 'h', 'cowcow@msn.com', '1992-03-03', 0);
INSERT INTO GEEK VALUES (4, 'missweb', 'PIAF', 'Anivia', 'f', 'missweb@free.fr', '1990-04-04', 0);
INSERT INTO GEEK VALUES (5, 'geekette', 'LA', 'Geekette', 'f', 'geekette@free.fr', '1991-05-05', 0);
INSERT INTO GEEK VALUES (6, 'ihateie02', 'GOOGLE', 'Chrome', 'h', 'ihateie02@hotmail.com', '1989-06-06', 0);
INSERT INTO GEEK VALUES (7, 'companion_cube', 'PORTAL', 'Glados', 'f', 'companion_cube@hotmail.com', '1991-07-07', 0);
INSERT INTO GEEK VALUES (8, 'i_aM-a&TesT', '<H2>', 'Titre', 'h', 'i_am-a-TesT@gmail.com', '1968-08-08', 0);
INSERT INTO GEEK VALUES (9, 'shadiscarde', 'METIE', 'Lisille', 'f', 'shadiscarde@neuf.fr', '1984-09-09', 0);
INSERT INTO GEEK VALUES (10, 'tragrartan', 'VALVER', 'Thotas', 'h', 'tragrartan@msn.com', '1961-02-28', 0);
--------------------------------------------------------------------------------------------------------------------


-- ASSOCIATION GEEK_INTERET -------------
----- Association des 'flags' -----------
INSERT INTO GEEK_INTERET VALUES (0, 0);
----- Autres associations ---------------
INSERT INTO GEEK_INTERET VALUES (1, 2);
INSERT INTO GEEK_INTERET VALUES (1, 7);
INSERT INTO GEEK_INTERET VALUES (2, 1);
INSERT INTO GEEK_INTERET VALUES (2, 4);
INSERT INTO GEEK_INTERET VALUES (2, 5);
INSERT INTO GEEK_INTERET VALUES (2, 9);
INSERT INTO GEEK_INTERET VALUES (3, 1);
INSERT INTO GEEK_INTERET VALUES (3, 3);
INSERT INTO GEEK_INTERET VALUES (3, 12);
INSERT INTO GEEK_INTERET VALUES (3, 13);
INSERT INTO GEEK_INTERET VALUES (4, 6);
INSERT INTO GEEK_INTERET VALUES (4, 8);
INSERT INTO GEEK_INTERET VALUES (5, 2);
INSERT INTO GEEK_INTERET VALUES (5, 11);
INSERT INTO GEEK_INTERET VALUES (6, 7);
INSERT INTO GEEK_INTERET VALUES (7, 3);
INSERT INTO GEEK_INTERET VALUES (8, 8);
INSERT INTO GEEK_INTERET VALUES (8, 9);
INSERT INTO GEEK_INTERET VALUES (8, 12);
INSERT INTO GEEK_INTERET VALUES (8, 13);
INSERT INTO GEEK_INTERET VALUES (9, 1);
INSERT INTO GEEK_INTERET VALUES (9, 2);
INSERT INTO GEEK_INTERET VALUES (9, 3);
INSERT INTO GEEK_INTERET VALUES (9, 4);
INSERT INTO GEEK_INTERET VALUES (10, 6);
-----------------------------------------
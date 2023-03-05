/**
 * Abstracts all SQL code relating to the NatDex table away from the Java application code.
 *
 * @author Josh Ashton
 */
public class NatDexSQL {
    /**
     * <p>Generates a SQL statement to create the NatDex table. Drops the table if it already exists, and creates the table.</p>
     *
     * @return CREATE SQL statement
     */
    public static String createTable() {
        return (
                "CREATE TABLE NatDex(\n" +
                        "DexID   INTEGER  NOT NULL PRIMARY KEY,\n" +
                        "Pokemon CHAR(10) NOT NULL,\n" +
                        "Mass    NUMERIC(5,1) NOT NULL,\n" +
                        "Height NUMERIC(5,1) NOT NULL, \n" +
                        "Type_I  CHAR(8) NOT NULL,\n" +
                        "Type_II CHAR(8))");
    }

    /**
     * <p>Generates a SQL statement to fill the NatDex table with data entries.</p>
     *
     * @return a series of SQL INSERT statements.
     */
    public static String fillTable() {
        return "INSERT INTO NatDex(DexID,Pokemon,Mass,Height,Type_I,Type_II) VALUES " +
                "(1,'Bulbasaur',6.9,0.7,'Grass','Poison'),\n" +
                "(2,'Ivysaur',13.0,1.0,'Grass','Poison'),\n" +
                "(3,'Venusaur',100.0,2.0,'Grass','Poison'),\n" +
                "(4,'Charmander',8.5,0.6,'Fire',NULL),\n" +
                "(5,'Charmeleon',19.0,1.1,'Fire',NULL),\n" +
                "(6,'Charizard',90.5,1.7,'Fire','Flying'),\n" +
                "(7,'Squirtle',9.0,0.5,'Water',NULL),\n" +
                "(8,'Wartortle',22.5,1.0,'Water',NULL),\n" +
                "(9,'Blastoise',85.5,1.6,'Water',NULL),\n" +
                "(10,'Caterpie',2.9,0.3,'Bug',NULL),\n" +
                "(11,'Metapod',9.9,0.7,'Bug',NULL),\n" +
                "(12,'Butterfree',32.0,1.1,'Bug','Flying'),\n" +
                "(13,'Weedle',3.2,0.3,'Bug','Poison'),\n" +
                "(14,'Kakuna',10.0,0.6,'Bug','Poison'),\n" +
                "(15,'Beedrill',29.5,1.0,'Bug','Poison'),\n" +
                "(16,'Pidgey',1.8,0.3,'Normal','Flying'),\n" +
                "(17,'Pidgeotto',30.0,1.1,'Normal','Flying'),\n" +
                "(18,'Pidgeot',39.5,1.5,'Normal','Flying'),\n" +
                "(19,'Rattata',3.5,0.3,'Normal',NULL),\n" +
                "(20,'Raticate',18.5,0.7,'Normal',NULL),\n" +
                "(21,'Spearow',2.0,0.3,'Normal','Flying'),\n" +
                "(22,'Fearow',38.0,1.2,'Normal','Flying'),\n" +
                "(23,'Ekans',6.9,2.0,'Poison',NULL),\n" +
                "(24,'Arbok',65.0,3.5,'Poison',NULL),\n" +
                "(25,'Pikachu',6.0,0.4,'Electric',NULL),\n" +
                "(26,'Raichu',30.0,0.8,'Electric',NULL),\n" +
                "(27,'Sandshrew',12.0,0.6,'Ground',NULL),\n" +
                "(28,'Sandslash',29.5,1.0,'Ground',NULL),\n" +
                "(29,'Nidoran ♀',7.0,0.4,'Poison',NULL),\n" +
                "(30,'Nidorina',20.0,0.8,'Poison',NULL),\n" +
                "(31,'Nidoqueen',60.0,1.3,'Poison','Ground'),\n" +
                "(32,'Nidoran ♂',9.0,0.5,'Poison',NULL),\n" +
                "(33,'Nidorino',19.5,0.9,'Poison',NULL),\n" +
                "(34,'Nidoking',62.0,1.4,'Poison','Ground'),\n" +
                "(35,'Clefairy',7.5,0.6,'Normal',NULL),\n" +
                "(36,'Clefable',40.0,1.3,'Normal',NULL),\n" +
                "(37,'Vulpix',9.9,0.6,'Fire',NULL),\n" +
                "(38,'Ninetales',19.9,1.1,'Fire',NULL),\n" +
                "(39,'Jigglypuff',5.5,0.5,'Normal',NULL),\n" +
                "(40,'Wigglytuff',12.0,1.0,'Normal',NULL),\n" +
                "(41,'Zubat',7.5,0.8,'Poison','Flying'),\n" +
                "(42,'Golbat',55.0,1.6,'Poison','Flying'),\n" +
                "(43,'Oddish',5.4,0.5,'Grass','Poison'),\n" +
                "(44,'Gloom',8.6,0.8,'Grass','Poison'),\n" +
                "(45,'Vileplume',18.6,1.2,'Grass','Poison'),\n" +
                "(46,'Paras',5.4,0.3,'Bug','Grass'),\n" +
                "(47,'Parasect',29.5,1.0,'Bug','Grass'),\n" +
                "(48,'Venonat',30.0,1.0,'Bug','Poison'),\n" +
                "(49,'Venomoth',12.5,1.5,'Bug','Poison'),\n" +
                "(50,'Diglett',0.8,0.2,'Ground',NULL),\n" +
                "(51,'Dugtrio',33.3,0.7,'Ground',NULL),\n" +
                "(52,'Meowth',4.2,0.4,'Normal',NULL),\n" +
                "(53,'Persian',32.0,1.0,'Normal',NULL),\n" +
                "(54,'Psyduck',19.6,0.8,'Water',NULL),\n" +
                "(55,'Golduck',76.6,1.7,'Water',NULL),\n" +
                "(56,'Mankey',28.0,0.5,'Fighting',NULL),\n" +
                "(57,'Primeape',32.0,1.0,'Fighting',NULL),\n" +
                "(58,'Growlithe',19.0,0.7,'Fire',NULL),\n" +
                "(59,'Arcanine',155.0,1.9,'Fire',NULL),\n" +
                "(60,'Poliwag',12.4,0.6,'Water',NULL),\n" +
                "(61,'Poliwhirl',20.0,1.0,'Water',NULL),\n" +
                "(62,'Poliwrath',54.0,1.3,'Water','Fighting'),\n" +
                "(63,'Abra',19.5,0.9,'Psychic',NULL),\n" +
                "(64,'Kadabra',56.5,1.3,'Psychic',NULL),\n" +
                "(65,'Alakazam',48.0,1.5,'Psychic',NULL),\n" +
                "(66,'Machop',19.5,0.8,'Fighting',NULL),\n" +
                "(67,'Machoke',70.5,1.5,'Fighting',NULL),\n" +
                "(68,'Machamp',130.0,1.6,'Fighting',NULL),\n" +
                "(69,'Bellsprout',4.0,0.7,'Grass','Poison'),\n" +
                "(70,'Weepinbell',6.4,1.0,'Grass','Poison'),\n" +
                "(71,'Victreebel',15.5,1.7,'Grass','Poison'),\n" +
                "(72,'Tentacool',45.5,0.9,'Water','Poison'),\n" +
                "(73,'Tentacruel',55.0,1.6,'Water','Poison'),\n" +
                "(74,'Geodude',20.0,0.4,'Rock','Ground'),\n" +
                "(75,'Graveler',105.0,1.0,'Rock','Ground'),\n" +
                "(76,'Golem',300.0,1.4,'Rock','Ground'),\n" +
                "(77,'Ponyta',30.0,1.0,'Fire',NULL),\n" +
                "(78,'Rapidash',95.0,1.7,'Fire',NULL),\n" +
                "(79,'Slowpoke',36.0,1.2,'Water','Psychic'),\n" +
                "(80,'Slowbro',78.5,1.6,'Water','Psychic'),\n" +
                "(81,'Magnemite',6.0,0.3,'Electric','Steel'),\n" +
                "(82,'Magneton',60.0,1.0,'Electric','Steel'),\n" +
                "(83,'Farfetch''d',15.0,0.8,'Normal','Flying'),\n" +
                "(84,'Doduo',39.2,1.4,'Normal','Flying'),\n" +
                "(85,'Dodrio',85.2,1.8,'Normal','Flying'),\n" +
                "(86,'Seel',90.0,1.1,'Water',NULL),\n" +
                "(87,'Dewgong',120.0,1.7,'Water','Ice'),\n" +
                "(88,'Grimer',30.0,0.9,'Poison',NULL),\n" +
                "(89,'Muk',30.0,1.2,'Poison',NULL),\n" +
                "(90,'Shellder',4.0,0.3,'Water',NULL),\n" +
                "(91,'Cloyster',132.5,1.5,'Water','Ice'),\n" +
                "(92,'Gastly',0.1,1.3,'Ghost','Poison'),\n" +
                "(93,'Haunter',0.1,1.6,'Ghost','Poison'),\n" +
                "(94,'Gengar',40.5,1.5,'Ghost','Poison'),\n" +
                "(95,'Onix',210.0,8.8,'Rock','Ground'),\n" +
                "(96,'Drowzee',32.4,1.0,'Psychic',NULL),\n" +
                "(97,'Hypno',75.6,1.6,'Psychic',NULL),\n" +
                "(98,'Krabby',6.5,0.4,'Water',NULL),\n" +
                "(99,'Kingler',60.0,1.3,'Water',NULL),\n" +
                "(100,'Voltorb',10.4,0.5,'Electric',NULL),\n" +
                "(101,'Electrode',66.6,1.2,'Electric',NULL),\n" +
                "(102,'Exeggcute',2.5,0.4,'Grass','Psychic'),\n" +
                "(103,'Exeggutor',120.0,2.0,'Grass','Psychic'),\n" +
                "(104,'Cubone',6.5,0.4,'Ground',NULL),\n" +
                "(105,'Marowak',45.0,1.0,'Ground',NULL),\n" +
                "(106,'Hitmonlee',49.8,1.5,'Fighting',NULL),\n" +
                "(107,'Hitmonchan',50.2,1.4,'Fighting',NULL),\n" +
                "(108,'Lickitung',65.5,1.2,'Normal',NULL),\n" +
                "(109,'Koffing',1.0,0.6,'Poison',NULL),\n" +
                "(110,'Weezing',9.5,1.2,'Poison',NULL),\n" +
                "(111,'Rhyhorn',115.0,1.0,'Ground','Rock'),\n" +
                "(112,'Rhydon',120.0,1.9,'Ground','Rock'),\n" +
                "(113,'Chansey',34.6,1.1,'Normal',NULL),\n" +
                "(114,'Tangela',35.0,1.0,'Grass',NULL),\n" +
                "(115,'Kangaskhan',80.0,2.2,'Normal',NULL),\n" +
                "(116,'Horsea',8.0,0.4,'Water',NULL),\n" +
                "(117,'Seadra',25.0,1.2,'Water',NULL),\n" +
                "(118,'Goldeen',15.0,0.6,'Water',NULL),\n" +
                "(119,'Seaking',39.0,1.3,'Water',NULL),\n" +
                "(120,'Staryu',34.5,0.8,'Water',NULL),\n" +
                "(121,'Starmie',80.0,1.1,'Water','Psychic'),\n" +
                "(122,'Mr. Mime',54.5,1.3,'Psychic',NULL),\n" +
                "(123,'Scyther',56.0,1.5,'Bug','Flying'),\n" +
                "(124,'Jynx',40.6,1.4,'Ice','Psychic'),\n" +
                "(125,'Electabuzz',30.0,1.1,'Electric',NULL),\n" +
                "(126,'Magmar',44.5,1.3,'Fire',NULL),\n" +
                "(127,'Pinsir',55.0,1.5,'Bug',NULL),\n" +
                "(128,'Tauros',88.4,1.4,'Normal',NULL),\n" +
                "(129,'Magikarp',10.0,0.9,'Water',NULL),\n" +
                "(130,'Gyarados',235.0,6.5,'Water','Flying'),\n" +
                "(131,'Lapras',220.0,2.5,'Water','Ice'),\n" +
                "(132,'Ditto',4.0,0.3,'Normal',NULL),\n" +
                "(133,'Eevee',6.5,0.3,'Normal',NULL),\n" +
                "(134,'Vaporeon',29.0,1.0,'Water',NULL),\n" +
                "(135,'Jolteon',24.5,0.8,'Electric',NULL),\n" +
                "(136,'Flareon',25.0,0.9,'Fire',NULL),\n" +
                "(137,'Porygon',36.5,0.8,'Normal',NULL),\n" +
                "(138,'Omanyte',7.5,0.4,'Rock','Water'),\n" +
                "(139,'Omastar',35.0,1.0,'Rock','Water'),\n" +
                "(140,'Kabuto',11.5,0.5,'Rock','Water'),\n" +
                "(141,'Kabutops',40.5,1.3,'Rock','Water'),\n" +
                "(142,'Aerodactyl',59.0,1.8,'Rock','Flying'),\n" +
                "(143,'Snorlax',460.0,2.1,'Normal',NULL),\n" +
                "(144,'Articuno',55.4,1.7,'Ice','Flying'),\n" +
                "(145,'Zapdos',52.6,1.6,'Electric','Flying'),\n" +
                "(146,'Moltres',60.0,2.0,'Fire','Flying'),\n" +
                "(147,'Dratini',3.3,1.8,'Dragon',NULL),\n" +
                "(148,'Dragonair',16.5,4.0,'Dragon',NULL),\n" +
                "(149,'Dragonite',210.0,2.2,'Dragon','Flying'),\n" +
                "(150,'Mewtwo',122.0,2.0,'Psychic',NULL),\n" +
                "(151,'Mew',4.0,0.4,'Psychic',NULL)";
    }

    /**
     * <p>Generates a SQL statement to drop the NatDex table.</p>
     *
     * @return a DROP SQL statement
     */
    public static String dropTable() {
        return ("DROP TABLE NatDex");
    }

    /**
     * <p>Generates a SQL statement to select all data from the NatDex table.</p>
     *
     * @return a SQL SELECT statement
     */
    public static String selectData() {
        return ("SELECT * FROM Pokemon");
    }

    /**
     * <p>Generates a SQL statement to select a specific data entry by a National Pokedex ID number.</p>
     *
     * @param dexID
     * @return a SQL SELECT statement
     */
    public static String selectData(int dexID) {
        return ("SELECT * FROM NatDex " +
                "WHERE DexID=" + dexID);
    }

    /**
     * <p>Generates a SQL statement to select all elements of a given type (Normal, Fire, Water, etc.)</p>
     *
     * @param type
     * @return
     */
    public static String selectData(String type) {
        return ("SELECT * FROM NatDex " +
                "WHERE Type_I=" + type +
                "OR TYPE_II=" + type + ";");
    }

    /**
     * <p>Generates a SQL statement to delete a specific data entry by a National Pokedex ID number.</p>
     *
     * @param dexID
     * @return a SQL DELETE statement
     */
    public static String deleteData(int dexID) {
        return ("DELETE FROM NatDex " +
                "WHERE DexID=" + dexID);
    }

    /**
     * <p>Generates a SQL statement to delete all data entries of a given type (Normal, Fire, Water, etc.)</p>
     *
     * @param type
     * @return a SQL DELETE statement
     */
    public static String deleteData(String type) {
        return ("DELETE FROM NatDex " +
                "WHERE Type_I=" + type +
                "OR TYPE_II=" + type + ";");
    }

    /**
     * <p>Generates SQL statement to sort data by a given option input.</p>
     * <br>
     * <p>1 = dexID ascending, 2 = dexID descending, 3 = type ascending, 4 = type descending, 5 = weight ascending, 6 = weight descending</p>
     *
     * @param option
     * @return a SQL ORDER BY statement
     */
    public static String order(int option) {
        switch (option) {
            case 1:
                return ("SELECT * FROM NatDex ORDER BY DexID ASC");
            case 2:
                return ("SELECT * FROM NatDex ORDER BY DexID DESC");
            case 3:
                return ("SELECT * FROM NatDex ORDER BY Type ASC");
            case 4:
                return ("SELECT * FROM NatDex ORDER BY Type DESC");
            case 5:
                return ("SELECT * FROM NatDex ORDER BY Weight ASC");
            case 6:
                return ("SELECT * FROM NatDex ORDER BY Weight DESC");
            default:
                return ("SELECT * FROM NatDex");
        }
    }
}

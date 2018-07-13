-- Creazione utente
--

CREATE USER IF NOT EXISTS 'esame_crusca'@'localhost' IDENTIFIED WITH mysql_native_password AS 'segreta';

--
-- Database: `trasporto_merci`
--

DROP DATABASE IF EXISTS `trasporto_merci` ;
CREATE DATABASE `trasporto_merci` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `trasporto_merci`;

--
-- Attribuzione privilegi Utente su DB
--

GRANT ALL PRIVILEGES ON *.* TO 'esame_crusca'@'localhost' REQUIRE NONE WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;

-- --------------------------------------------------------

--
-- Struttura della tabella `costo_mezzo_trasporto`
--

CREATE TABLE IF NOT EXISTS`costo_mezzo_trasporto` (
  `id` int(11) NOT NULL,
  `nome_mezzo` varchar(255) NOT NULL,
  `peso_massimo` float(10,2) NOT NULL,
  `costo` float(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `merce`
--

CREATE TABLE IF NOT EXISTS`merce` (
  `id` int(11) NOT NULL,
  `codice` varchar(50) NOT NULL,
  `descrizione` varchar(255) NOT NULL,
  `peso` float(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `merce_spedizione`
--

CREATE TABLE IF NOT EXISTS`merce_spedizione` (
  `id` int(11) NOT NULL,
  `id_spedizione` int(11) NOT NULL,
  `id_merce` int(11) NOT NULL,
  `quantità` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `spedizione`
--

CREATE TABLE IF NOT EXISTS`spedizione` (
  `id` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `data` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `costo_mezzo_trasporto`
--
ALTER TABLE `costo_mezzo_trasporto`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `merce`
--
ALTER TABLE `merce`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `merce_spedizione`
--
ALTER TABLE `merce_spedizione`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_merce` (`id_merce`),
  ADD KEY `id_spedizione` (`id_spedizione`);

--
-- Indici per le tabelle `spedizione`
--
ALTER TABLE `spedizione`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `costo_mezzo_trasporto`
--
ALTER TABLE `costo_mezzo_trasporto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `merce`
--
ALTER TABLE `merce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `merce_spedizione`
--
ALTER TABLE `merce_spedizione`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `spedizione`
--
ALTER TABLE `spedizione`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `merce_spedizione`
--
ALTER TABLE `merce_spedizione`
  ADD FOREIGN KEY (`id_merce`) REFERENCES `merce` (`id`),
  ADD FOREIGN KEY (`id_spedizione`) REFERENCES `spedizione` (`id`);


INSERT INTO `merce` (`codice`, `descrizione`, `peso`) VALUES
('PNDRV8', 'Pen drive USB 64G no brand', '0.15'),
('DCP-J715E', 'Stampante Brother DCP J715 W', '5.3'),
('LNVCX1', 'Notebook Lenovo Carbon X1', '1.9'),
('HUP20', 'Smartphone Huawei P20', '0.53'),
('BSHT1R', 'Ampli Combo valvolare BlackStar HT 1-R', '6');

INSERT INTO `costo_mezzo_trasporto` (`nome_mezzo`, `peso_massimo`, `costo`) VALUES
('A piedi', '1', '5.90'),
('Bicicletta', '5', '7.90'),
('Ape', '30', '12.90'),
('Drone piccolo', '1.5', '6.50'),
('Scooter', '7.5', '9.90'),
('Furgone', '40', '13.90'),
('Piccione viaggiatore', '0.7', '5.20'),
('Drone grande', '3', '6.90'),
('Automobile', '25', '11.50');

INSERT INTO `spedizione` (`numero`, `date`) VALUES 
('34564', '2018-07-17 00:00:00'),
('3541231', '2018-07-31 00:00:00');

INSERT INTO `merce_spedizione` (`id`, `id_spedizione`, `id_merce`, `quantità`) VALUES
(NULL, '1', '2', '2'),
(NULL, '1', '1', '3'),
(NULL, '2', '5', '10'),
(NULL, '2', '2', '10');
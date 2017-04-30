 CREATE DATABASE webproject;
 
 CREATE TABLE `transaction` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Num` varchar(6) NOT NULL,
  `PmtId` varchar(35) NOT NULL,
  `InstdAmt` DOUBLE NOT NULL,
  `MndtId` varchar(35) NOT NULL,
  `DtOfSgntr` varchar(10) NOT NULL,
  `BIC` varchar(11) NOT NULL,
  `Nm` varchar(35) NOT NULL,
  `IBAN` varchar(34) NOT NULL,
  `RmtInf` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ;

INSERT INTO `transaction` (`Id`, `Num`, `PmtId`, `InstdAmt`, `MndtId`, `DtOfSgntr`, `BIC`, `Nm`, `IBAN`, `RmtInf`) VALUES
(1, 'BB0001', 'REF OPE ABCD', 1123.00, 'MANDAT NO 111111', '2010-01-01', 'ABNAFRPP', 'Mr Debiteur N1', 'FR7630001007941234567890155', 'Facture N1'),
(2, 'BB0002', 'REF OPE EFGH', 1167.00, 'MANDAT NO 111112', '2011-02-03', 'AECFFR21', 'Mr Debiteur N2', 'FR7630004000031234567890103', 'Facture N2'),
(3, 'BB0003', 'REF OPE IGKL', 300.23, 'MANDAT NO 111113', '2011-05-21', 'AFRIFRPP', 'Mr Debiteur N3', 'FR7630006000011234567890199', 'Facture N3');
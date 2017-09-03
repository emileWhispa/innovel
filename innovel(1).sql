-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 30, 2017 at 12:26 AM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `innovel`
--

-- --------------------------------------------------------

--
-- Table structure for table `cashin`
--

CREATE TABLE IF NOT EXISTS `cashin` (
  `id` tinyint(11) NOT NULL,
  `fromu` varchar(255) NOT NULL,
  `amount` int(255) NOT NULL,
  `motif` varchar(2000) NOT NULL,
  `receipt` varchar(255) NOT NULL,
  `doneby_id` tinyint(11) NOT NULL,
  `receipt_category` varchar(100) NOT NULL,
  `vat_category` varchar(100) NOT NULL,
  `mode` varchar(250) NOT NULL,
  `other_info` varchar(2500) NOT NULL,
  `date` varchar(255) NOT NULL,
  `delete_status` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cashin`
--

INSERT INTO `cashin` (`id`, `fromu`, `amount`, `motif`, `receipt`, `doneby_id`, `receipt_category`, `vat_category`, `mode`, `other_info`, `date`, `delete_status`) VALUES
(1, 'UWAASE Betty', 10000000, 'Epfundo software development first installment ', '002MG2017', 11, '', '', '', '', '2017-08-10', '0'),
(2, 'Kalisa Aimable', 30000000, 'warehouse software development', '003MG2017', 11, '', '', '', '', '2017-08-17', '0'),
(3, 'murautsa', 100000, 'Training', '002MG2017', 11, '', '', '', '', '2017-08-23', '0'),
(4, 'murautsa', 100000, 'Training', '002MG2017', 11, '', '', '', '', '2017-08-23', '0'),
(5, 'jojo', 40000000, 'company remforcment', 'ff', 11, '', '', '', '', '2017-08-25', '0'),
(6, 'Muyanog', 4000, 'buy house', '005MG2017', 11, 'invest', '', '', '', '2017-08-16', '0'),
(7, 'muyango kina', 4000000, 'buy house', '006MH2017', 11, 'nature', 'included', '', '', '2017-08-25', '0'),
(8, 'Munyawera Buyoga', 100, 'buy choloate', '008MG2017', 11, 'nature', 'included', '', '', '2017-08-17', '0'),
(9, 'Kayonga Charles', 300, 'buy sweets', '010MG2017', 11, 'nature', 'excluded', '', '', '2017-08-18', '0'),
(10, 'muyango kagoma', 300, 'buy a house', '011MG2017', 11, 'nature', 'exempted', '', '', '2017-08-26', '0'),
(11, 'kwizeraemil', 400, 'buy a car', '01MG2017', 11, 'nature', 'included', '', '', '2017-08-24', '0'),
(12, 'Kalima', 400, 'buy fireswood', '011MG2017', 11, 'nature', 'included', '', '', '2017-08-24', '0'),
(13, 'amigo emile', 3000, 'get cat', '012MG2017', 11, 'nature', 'included', 'cash', '', '2017-08-18', '0'),
(14, 'Mutavu Ernest', 4000, 'buy a new game', '013MG2017', 11, 'nature', 'included', 'check', '', '2017-08-26', '0'),
(15, 'Mutagengwa ernest', 3000000, 'software devlopment dev', '014MG2017', 11, 'nature', 'exempted', 'other', 'Mobile Money', '2017-08-25', '0'),
(16, 'Mutagengwa ernest', 3000000, 'software devlopment dev', '014MG2017', 11, 'nature', 'exempted', 'other', 'Mobile Money', '2017-08-25', '0'),
(17, 'Mutagengwa ernesto', 3000000, '		software devlopment dev\r\n	\r\n	\r\n	', '014MG2017', 11, 'nature', 'exempted', 'other', 'Mobile Money', '2017-08-25', '1'),
(18, 'Bana Eric', 34000000, 'Univeristy management software full bouquette', '017MG2017', 11, 'nature', 'exempted', 'other', 'Mone Gramm', '2017-08-26', '1'),
(19, 'Mugayo Kigoma', 40000000, 'Data management\r\n	', '016MG2017', 11, 'nature', 'included', 'cash', '', '2017-08-23', '0');

-- --------------------------------------------------------

--
-- Table structure for table `cashout`
--

CREATE TABLE IF NOT EXISTS `cashout` (
  `id` tinyint(11) NOT NULL,
  `sendto` varchar(250) NOT NULL,
  `amount` int(255) NOT NULL,
  `motif` varchar(2550) NOT NULL,
  `upload` varchar(200) NOT NULL,
  `doneby_id` tinyint(11) NOT NULL,
  `date` varchar(2000) NOT NULL,
  `delete_status` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cashout`
--

INSERT INTO `cashout` (`id`, `sendto`, `amount`, `motif`, `upload`, `doneby_id`, `date`, `delete_status`) VALUES
(1, 'Innovel staffs', 40000000, 'Shawages\r\n	', 'sewe', 11, '2017-08-22', '0');

-- --------------------------------------------------------

--
-- Table structure for table `covered`
--

CREATE TABLE IF NOT EXISTS `covered` (
  `id` int(255) NOT NULL,
  `debt_id` tinyint(255) NOT NULL,
  `amount` int(255) NOT NULL,
  `date` varchar(2000) NOT NULL,
  `delete_status` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `covered`
--

INSERT INTO `covered` (`id`, `debt_id`, `amount`, `date`, `delete_status`) VALUES
(1, 1, 15000000, '2017-08-25', '0'),
(2, 1, 50000, '2017-08-17', '0'),
(3, 3, 60000, '2017-08-18', '1'),
(4, 3, 2000, '2017-08-04', '0');

-- --------------------------------------------------------

--
-- Table structure for table `debts`
--

CREATE TABLE IF NOT EXISTS `debts` (
  `id` tinyint(255) NOT NULL,
  `fromu` varchar(2000) NOT NULL,
  `amount` int(255) NOT NULL,
  `motif` varchar(2550) NOT NULL,
  `doneby_id` tinyint(11) NOT NULL,
  `date` varchar(2550) NOT NULL,
  `delete_status` varchar(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `debts`
--

INSERT INTO `debts` (`id`, `fromu`, `amount`, `motif`, `doneby_id`, `date`, `delete_status`) VALUES
(1, 'jojo', 40000000, 'company reimforcment', 11, '2017-08-03', '1'),
(2, '', 900, '', 11, '', '1'),
(3, 'data', 200000, 'dict', 11, '2017-08-18', '0');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE IF NOT EXISTS `department` (
  `id` bigint(20) NOT NULL,
  `department_name` varchar(255) DEFAULT NULL,
  `department_details` mediumtext,
  `department_logo` varchar(255) DEFAULT NULL,
  `delete_status` varchar(255) DEFAULT NULL,
  `level` int(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `department_name`, `department_details`, `department_logo`, `delete_status`, `level`) VALUES
(2, 'EDUCATION SOFTWARES', 'Looking for educational software with educational orientation? Looking for educational software for kids, children or schools? Under the “Educational Software” category, you will find updated reviews of free and paid educational software offering a variety of online learning tools. The category offers a selection of recommended programs that will enable you to enrich your educational and learning experience, both for yourself and for others. ', '1503048097039Education softwares.png', '1', 0),
(3, 'EDUCATION SOFTWARES', 'Looking for educational software with educational orientation? you will find updated reviews and recommended programs that will enable you to enrich your educational and learning experience, both for yourself and for others. ', '1503048530947Education softwares.png', '1', 0),
(4, 'HEALTH SOFTWARES', 'Health software includes a wide class of systems that manage the clinical and administrative functions of healthcare organizations. ', '1503049477296health.jpg', '', 6),
(5, 'EDUCATION SOFTWARES', 'Looking for educational software with educational orientation? you will find recommended programs that will enable you to enrich your educational experience. ', '1503052145671Education softwares.png', '', 0),
(6, NULL, 'This system is a complete education software solution that supporting universities to build, manage and extend their digital campus. \r\n\r\nSpecially built for higher education, our systems enable you to:\r\n\r\nAutomate admissions,provide one-stop student access, simplify records management, engage faculty, manage resources and strengthen decision making.\r\n\r\nThis software is the best one to solve the accounting purpose where all entries done automatically in the software according to the invoice, receipt and payments.\r\n\r\nFor more and addition information, please do not hesitate to contact us!\r\n\r\n or   \r\n\r\nTo visit our system click on demo link and use the bellow USERNAME AND PASSWORD:\r\n\r\nUSERNAME: university\r\nPASSWORD: system        \r\n', '1503052283353economic.jpg', '1', 0),
(7, 'ECONOMIC SOFTWARES', 'Computer program for building and simulating dynamic, monetary economic models, models without equilibrium and with a financial sector.', '1503052823074WOUW.png', '1', 0),
(8, 'ECONOMIC SOFTWARES', 'Computer program for building and simulating dynamic, monetary economic models, models without equilibrium and with a financial sector.', '1503053304128DFD.png', '1', 0),
(9, 'ECONOMIC SOFTWARES', 'Computer program for building and simulating dynamic, monetary economic models, models without equilibrium and with a financial sector.\r\n', '1503519197433ECO LG.png', '', 2),
(10, 'AGRICULTURAL', ' It is an information system, as one of the key players helping to support farm performance and farm production quality.', '1503169797456agricultural.jpg', '1', 0),
(11, 'AGRICULTURAL SOFTWARES', ' It is an information system, as one of the key players helping to support farm performance and farm production quality.', '1503169884039agricultural.jpg', '', 5),
(12, 'ORGANIZATION SOFTWARES', 'Organizing software is set apart from information managers that track the important tasks and documents in your personal and professional lives.', '1503169931853organ.jpg', '0', 1),
(13, 'GAMES SOFTWARES', 'Free software Download recommended windows PC apps, reviews and rating. All the best free software and games for Windows.', '1503169990684gms.jpg', '', 3),
(14, 'jjhj', 'nhbhjj', 'logo.png', '1', 0),
(15, 'DIVERS SYSTEM', 'These are other softwares which are not easly to clasify but which are userfull in daily life.        ', '1503989992455CaptureP.PNG', '', 4);

-- --------------------------------------------------------

--
-- Table structure for table `details`
--

CREATE TABLE IF NOT EXISTS `details` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `delete_status` varchar(255) DEFAULT NULL,
  `content` varchar(2550) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `details`
--

INSERT INTO `details` (`id`, `name`, `delete_status`, `content`, `project_id`) VALUES
(1, 'System description', '1', 'This in a system  which is able to manage all activities within a given organization and track attendance and services provided to their beneficiaries', 1),
(2, 'uuuuu', '1', 'uuuuu', 3),
(3, 'Number of users', '1', '4 users', 1),
(4, 'a', '1', 'jsfthrf\r\nfdsdfhkjhfdkdfjssdf\r\nfdfdkjhk\r\ndfdffdshj\r\n\r\n\r\ndsdfkjlsfd\r\ndkdfjfd', 5),
(5, '', '1', 'fine        ', 10),
(6, '', '', 'This system is a complete education software solution that supporting universities to build, manage and extend their digital campus. \r\n\r\nSpecially built for higher education, our systems enable you to:\r\n\r\nAutomate admissions,provide one-stop student access, simplify records management, engage faculty, manage resources and strengthen decision making.\r\n\r\nThis software is the best one to solve the accounting purpose where all entries done automatically in the software according to the invoice, receipt and payments.\r\n\r\nFor more and addition information, please do not hesitate to contact us!\r\n\r\n or   \r\n\r\nTo visit our system click on demo link and use the bellow USERNAME AND PASSWORD:\r\n\r\nUSERNAME: university\r\nPASSWORD: system        \r\n	\r\n	', 10),
(7, '', '', ' School management is the best solution  tool to increase the global education level and it is the organized tool to all stakeholders (student, parents, teachers, staffs and donors ) with multiple channels of communication.\r\n\r\nIt allows all parties to have access on: Data visualization of your institution''s performance, complete visibility into income and expenses, secured portal for students, parents and teachers, account a administrator, out o the box flexibility for all grading type from school management system.\r\n	\r\n\r\nFor more and addition information, please do not hesitate to contact us!\r\n\r\n or   \r\n\r\nTo visit our system click on demo link and use the bellow USERNAME AND PASSWORD:\r\n\r\nUSERNAME: school\r\nPASSWORD: system  ', 12),
(8, '', '', 'This is a software which helps user to measure himself in order to know which carrier is suitable to him/her by passing a simple test which is automatically evaluate him        ', 28);

-- --------------------------------------------------------

--
-- Table structure for table `forums`
--

CREATE TABLE IF NOT EXISTS `forums` (
  `id` tinyint(11) NOT NULL,
  `forum_name` varchar(40) NOT NULL,
  `admin_id` tinyint(11) NOT NULL,
  `time` varchar(255) NOT NULL,
  `delete_status` varchar(2000) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `forums`
--

INSERT INTO `forums` (`id`, `forum_name`, `admin_id`, `time`, `delete_status`) VALUES
(1, 'Dats never shit', 10, '', ''),
(2, 'ECONOMIC SOFTWARESPLx', 10, '', ''),
(3, 'aba programmers', 12, '', ''),
(4, 'Group convrsation', 10, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `forum_data`
--

CREATE TABLE IF NOT EXISTS `forum_data` (
  `id` tinyint(255) NOT NULL,
  `content` varchar(2550) NOT NULL,
  `forum_id` tinyint(255) NOT NULL,
  `member_id` tinyint(255) NOT NULL,
  `status` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `date` varchar(255) NOT NULL,
  `delete_status` varchar(250) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `forum_data`
--

INSERT INTO `forum_data` (`id`, `content`, `forum_id`, `member_id`, `status`, `type`, `date`, `delete_status`) VALUES
(1, 'Hiii', 1, 11, 'unread', 'text', '', ''),
(2, 'hgyhguyhk\r\n', 1, 10, 'unread', 'text', '', ''),
(3, 'bhhbhbj\r\n', 1, 10, 'unread', 'text', '', ''),
(4, 'ghjjkihghikjlkuglkojijijikbgvg\r\n', 1, 10, 'unread', 'text', '', ''),
(5, 'hhhbjhnjmijmijmkmmmmm\r\n', 1, 10, 'unread', 'text', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE IF NOT EXISTS `members` (
  `id` tinyint(255) NOT NULL,
  `member_id` tinyint(255) NOT NULL,
  `forum_id` tinyint(255) NOT NULL,
  `date` varchar(2000) NOT NULL,
  `delete_status` varchar(2000) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`id`, `member_id`, `forum_id`, `date`, `delete_status`) VALUES
(1, 10, 1, '', ''),
(2, 11, 1, '', ''),
(3, 10, 2, '', ''),
(4, 13, 2, '', ''),
(5, 11, 2, '', ''),
(6, 18, 2, '', ''),
(7, 12, 3, '', ''),
(8, 10, 3, '', ''),
(9, 13, 3, '', ''),
(10, 10, 4, '', ''),
(11, 11, 4, '', ''),
(12, 12, 4, '', ''),
(13, 13, 4, '', ''),
(14, 14, 4, '', ''),
(15, 15, 4, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE IF NOT EXISTS `messages` (
  `id` bigint(20) NOT NULL,
  `message` varchar(2550) DEFAULT NULL,
  `delete_status` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `sendto_id` bigint(20) DEFAULT NULL,
  `fromu_id` bigint(20) DEFAULT NULL,
  `type` varchar(230) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`id`, `message`, `delete_status`, `status`, `sendto_id`, `fromu_id`, `type`) VALUES
(1, 'hi brother , hw are you?\r\n', '', 'read', 11, 10, 'text'),
(2, 'I really like this\r\n', '', 'read', 11, 10, 'text'),
(3, 'hi brother?\r\n', '', 'read', 10, 12, 'text'),
(4, 'hey\r\n', '', 'read', 12, 10, 'text'),
(5, 'whtp?\r\n', '', 'read', 12, 10, 'text'),
(6, 'chat is working fine?\r\n', '', 'read', 10, 12, 'text'),
(7, 'we can facebbook here now\r\n', '', 'read', 10, 12, 'text'),
(8, 'Hey\r\n', '', 'read', 12, 10, 'text'),
(9, 'yp that great\r\n', '', 'read', 12, 10, 'text'),
(10, 'amusing\r\n', '', 'read', 12, 10, 'text'),
(11, 'i will add the option of attaching files\r\n', '', 'read', 10, 12, 'text'),
(12, 'hello\r\n', '', 'read', 13, 10, 'text'),
(13, 'boss\r\n', '', 'read', 13, 10, 'text'),
(14, 'hi???\r\n', '', 'read', 13, 12, 'text'),
(15, 'There still department word instead of Software category\r\n', '', 'read', 12, 10, 'text'),
(16, 'amusing work\r\n', '', 'read', 13, 10, 'text'),
(17, 'Let me check \r\n', '', 'read', 10, 12, 'text'),
(18, 'So much \r\n', '', 'read', 11, 10, 'text'),
(19, 'it is amizing\r\n', '', 'read', 11, 10, 'text'),
(20, 'Hey?\r\n', '', 'read', 11, 12, 'text'),
(21, 'already in!!!!\r\n', '', 'read', 12, 11, 'text'),
(22, 'that ''s greaty brother?\r\n', '', 'read', 11, 12, 'text'),
(23, 'q\r\n', '', 'read', 10, 12, 'text'),
(24, 'fuck you\r\n', '', 'read', 12, 10, 'text'),
(25, 'hi\r\n', '', 'read', 11, 10, 'text'),
(26, '\r\n    public static Result updateCashin() {\r\n        if(session("userId") != null ){\r\n            Form<Cashin> userForm = Form.form(Cashin.class).bindFromRequest();\r\n            Long id = Long.parseLong( userForm.field("id").value() );\r\n            Cashin dx = userForm.get();\r\n            Cashin dep = Cashin.finderById( id );\r\n            dep.fromu = userForm.field("fromu").value();\r\n            dep.amount = Integer.valueOf(userForm.field("amount").value());\r\n            dep.motif = userForm.field("details").value();\r\n            dep.update();\r\n            return ok("ok");\r\n        }else{\r\n            return ok("Error Login");\r\n        }\r\n    }\r\n', '', 'read', 10, 11, 'text'),
(27, 'fuck u?\r\n', '', 'read', 11, 10, 'text'),
(28, 'XXXXXXXXXXXXX\r\n', '', 'read', 12, 10, 'text'),
(29, '#b7630f$#b7630f\r\n', '', 'read', 10, 12, 'text'),
(30, '#\r\n', '', 'read', 12, 10, 'text'),
(31, ',i.project.id\r\n', '', 'read', 10, 14, 'text'),
(32, '@if( loged != null ){\r\n', '', 'read', 12, 10, 'text'),
(33, 'Customize options on chat room\r\nChange your chat colors\r\nAll about Forums\r\nDelete Conversations\r\n\r\n', '', 'read', 10, 12, 'text'),
(34, 'gut???\r\n', '', 'read', 12, 10, 'text'),
(35, 'mmmmmmm', '', 'read', 11, 10, 'text'),
(36, 'tokaaaaaaaaaaaaaaaaaaaaaaaaaaa\r\n', '', 'read', 12, 11, 'text'),
(37, 'Customize options on chat room\r\nChange your chat colors\r\nAll about Forums\r\nDelete Conversations\r\nion:absolute;width:23px;height:23px;top:10px;right:10px;background-color:#1e90ff;border:none;color:#fff;}\r\n#my-data:after{bottom:100%;border: solid transparent;content:" ";position: absolute;border-bottom-color:red;border-width: 8px;right:2%;}\r\n\r\n\r\n', '', 'read', 10, 12, 'text'),
(38, 'what\r\n', '', 'read', 12, 10, 'text'),
(39, '????\r\n', '', 'read', 12, 10, 'text'),
(40, 'hii brother wait a bit am on it\r\n', '', 'read', 10, 12, 'text'),
(41, 'great\r\n', '', 'read', 12, 10, 'text'),
(42, 'wonderful\r\n work ', '', 'read', 12, 10, 'text'),
(43, 'yes of course\r\n', '', 'read', 10, 12, 'text');

-- --------------------------------------------------------

--
-- Table structure for table `owned`
--

CREATE TABLE IF NOT EXISTS `owned` (
  `id` tinyint(11) NOT NULL,
  `delete_status` varchar(255) DEFAULT NULL,
  `owner_id` tinyint(11) DEFAULT NULL,
  `project_id` tinyint(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `owned`
--

INSERT INTO `owned` (`id`, `delete_status`, `owner_id`, `project_id`) VALUES
(1, '', 14, 2),
(2, '', 15, 2),
(3, '', 16, 7),
(4, '', 16, 7),
(5, '', 17, 7),
(6, '', 14, 9),
(7, '', 19, 11);

-- --------------------------------------------------------

--
-- Table structure for table `payed`
--

CREATE TABLE IF NOT EXISTS `payed` (
  `id` tinyint(255) NOT NULL,
  `sent_id` tinyint(255) NOT NULL,
  `amount` int(255) NOT NULL,
  `date` varchar(2000) NOT NULL,
  `delete_status` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `play_evolutions`
--

CREATE TABLE IF NOT EXISTS `play_evolutions` (
  `id` int(11) NOT NULL,
  `hash` varchar(255) NOT NULL,
  `applied_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `apply_script` text,
  `revert_script` text,
  `state` varchar(255) DEFAULT NULL,
  `last_problem` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `play_evolutions`
--

INSERT INTO `play_evolutions` (`id`, `hash`, `applied_at`, `apply_script`, `revert_script`, `state`, `last_problem`) VALUES
(1, '38b073a21409c61e7a50348e1511b98d411d33f6', '2017-08-05 22:57:22', 'create table department (\nid                        bigint auto_increment not null,\ndepartment_name           varchar(255),\ndepartment_details        varchar(255),\ndepartment_logo           varchar(255),\ndelete_status             varchar(255),\nconstraint pk_department primary key (id))\n;\n\ncreate table details (\nid                        bigint auto_increment not null,\nname                      varchar(255),\ndelete_status             varchar(255),\ncontent                   varchar(255),\nproject_id                bigint,\nconstraint pk_details primary key (id))\n;\n\ncreate table messages (\nid                        bigint auto_increment not null,\nmessage                   varchar(255),\ndelete_status             varchar(255),\nstatus                    varchar(255),\nsendto_id                 bigint,\nfromu_id                  bigint,\nconstraint pk_messages primary key (id))\n;\n\ncreate table projects (\nid                        bigint auto_increment not null,\nproject_name              varchar(255),\ndeveloper_id              bigint,\nproject_link              varchar(255),\nproject_logo              varchar(255),\ndelete_status             varchar(255),\ndepart_id                 bigint,\nconstraint pk_projects primary key (id))\n;\n\ncreate table subtasks (\nid                        bigint auto_increment not null,\nsub_name                  varchar(255),\nsub_detail                varchar(255),\ncomplete                  integer,\ndelete_status             varchar(255),\ntask_id                   bigint,\nconstraint pk_subtasks primary key (id))\n;\n\ncreate table tasks (\nid                        bigint auto_increment not null,\ntask_name                 varchar(255),\ncomplete                  integer,\nowner_id                  bigint,\nproj_id                   bigint,\ndelete_status             varchar(255),\nconstraint pk_tasks primary key (id))\n;\n\ncreate table users (\nid                        bigint auto_increment not null,\nfirst_name                varchar(255),\nlast_name                 varchar(255),\nrole                      varchar(255),\nphone                     varchar(255),\ndob                       varchar(255),\nage                       varchar(255),\nemail                     varchar(255),\nphoto                     varchar(255),\nusername                  varchar(255),\npassword                  varchar(255),\ndelete_status             tinyint(1) default 0,\ndelete_reason             varchar(255),\ndone_by                   varchar(255),\nconstraint pk_users primary key (id))\n;\n\nalter table details add constraint fk_details_project_1 foreign key (project_id) references projects (id) on delete restrict on update restrict;\ncreate index ix_details_project_1 on details (project_id);\nalter table messages add constraint fk_messages_sendto_2 foreign key (sendto_id) references users (id) on delete restrict on update restrict;\ncreate index ix_messages_sendto_2 on messages (sendto_id);\nalter table messages add constraint fk_messages_fromu_3 foreign key (fromu_id) references users (id) on delete restrict on update restrict;\ncreate index ix_messages_fromu_3 on messages (fromu_id);\nalter table projects add constraint fk_projects_developer_4 foreign key (developer_id) references users (id) on delete restrict on update restrict;\ncreate index ix_projects_developer_4 on projects (developer_id);\nalter table projects add constraint fk_projects_depart_5 foreign key (depart_id) references department (id) on delete restrict on update restrict;\ncreate index ix_projects_depart_5 on projects (depart_id);\nalter table subtasks add constraint fk_subtasks_task_6 foreign key (task_id) references tasks (id) on delete restrict on update restrict;\ncreate index ix_subtasks_task_6 on subtasks (task_id);\nalter table tasks add constraint fk_tasks_owner_7 foreign key (owner_id) references users (id) on delete restrict on update restrict;\ncreate index ix_tasks_owner_7 on tasks (owner_id);\nalter table tasks add constraint fk_tasks_proj_8 foreign key (proj_id) references projects (id) on delete restrict on update restrict;\ncreate index ix_tasks_proj_8 on tasks (proj_id);', 'SET FOREIGN_KEY_CHECKS=0;\n\ndrop table department;\n\ndrop table details;\n\ndrop table messages;\n\ndrop table projects;\n\ndrop table subtasks;\n\ndrop table tasks;\n\ndrop table users;\n\nSET FOREIGN_KEY_CHECKS=1;', 'applied', '');

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE IF NOT EXISTS `projects` (
  `id` bigint(20) NOT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `developer_id` bigint(20) DEFAULT NULL,
  `project_link` varchar(255) DEFAULT NULL,
  `project_logo` varchar(255) DEFAULT NULL,
  `project_details` varchar(20000) NOT NULL,
  `delete_status` varchar(255) DEFAULT NULL,
  `done` tinyint(11) NOT NULL,
  `depart_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `projects`
--

INSERT INTO `projects` (`id`, `project_name`, `developer_id`, `project_link`, `project_logo`, `project_details`, `delete_status`, `done`, `depart_id`) VALUES
(1, 'Activity Management System', 13, '104.131.0.237:9001', '1503082156228logo.png', '', '1', 1, 4),
(2, 'HealthAppex', 13, '104.131.0.237:9002', '1503084919329paid.jpg', '', '1', 0, 9),
(3, 'EPFUMU', 13, 'wwwjnjjkjkjjkjkjkj', '1503085032791epfundo.png', '', '1', 1, 9),
(4, 'EPFUNDO', 13, '123456789', '15032975213051503085032791epfundo.png', '', '1', 0, 9),
(5, 'school management system', 12, '104.131.0.237:9001', '1503420172248so MUcH.jpg', '', '1', 1, 5),
(6, 'School Management System', 12, 'www.gld.s', '1503420897207dope.jpg', 'how is the project is to control all the schools in rwanda', '1', 1, 5),
(7, 'Push box game', 12, '104.131.0.237:9002', '1503422626346latePhoto.jpg', '104.131.0.237:9002 how are you my friend download this game via provided link', '1', 0, 13),
(8, 'Royality clients system', 12, 'http://127.0.0.1:9000/', '150364581730211113.png', 'i would ike to invite you to like this project        ', '1', 1, 12),
(9, 'Girikna management system', 12, 'http://127.0.0.1:9000/#', '1503652257979attach.png', 'visit using this link        ', '1', 0, 11),
(10, 'UNIVERSITY MANAGEMENT SYSTEM', 13, '169.254.230.159:9000/', '1503938465254ums.png', 'This system is a complete education software solution that supporting universities to build, manage and extend their digital campus.', '', 1, 5),
(11, 'ROYALTY ENGINE ', 13, '169.254.230.159:9000/', '1503940778591sms.png', 'Royalty engine is a specific and unique software that used by divers organization to increase the number of customers based on royalty system to manage and maintain them in  greatest systematic way.          \n	\n	', '0', 0, 12),
(12, 'SCHOOL MANAGEMENT SYSTEM', 12, '169.254.230.159:9000', '1503950113194sms.png', 'It is the best solution to increase the global education level and  organized communication tool to all stakeholders (Students, Parents, Searchers, staff and donors)....\r\n	\r\n	\r\n	', '', 1, 5),
(13, 'EXAMS SITTING MANAGEMENT SYSTEM', 13, '	N/A        ', '1503951584768exams.jpg', '		N/A        \r\n	', '', 1, 5),
(14, 'ATTENDANCE MANAGEMENT SOFTWARE ', 12, '	N/A        ', '1503951736052attedency.jpg', '		N/A        \r\n	', '', 1, 5),
(15, 'HOSPITAL MANAGEMENT SYSTEM', 13, '	N/A        ', '1503953175884hospital.jpg', '		N/A        \r\n	', '', 1, 4),
(16, 'MEDICAL CONSULTATION MANAGEMENT SYSTEM', 13, '	N/A        ', '1503953288650consultation.jpg', '		N/A        \r\n	', '', 1, 4),
(17, 'HEATH APPEX', 13, '	N/A        ', '1503953369558Untitled-1.jpg', '		N/A        \r\n	', '', 1, 4),
(18, 'IMIHIGO M%E SYSTEM', 12, '	N/A        ', '1503953811904imihigo.jpg', '		N/A        \r\n	', '', 1, 12),
(19, 'IMIHIGO M%E SYSTEM', 12, '169.254.230.159:9000', '1503953811954imihigo.jpg', 'N/A        ', '1', 1, 12),
(20, 'IMIHIGO M%E SYSTEM', 12, '169.254.230.159:9000', '1503953811793imihigo.jpg', 'N/A        ', '1', 1, 12),
(21, 'E-BILLING', 13, '	N/A        ', '1503953900260billing mgt.jpg', '		N/A        \r\n	', '', 1, 9),
(22, 'EPFUNDO', 13, '	N/A        ', '1503953997576epfundo.png', '		N/A        \r\n	', '', 1, 9),
(23, 'STOCK MANAGEMENT SYSTEM', 13, '	N/A        ', '1503954080912stock mgt.jpg', '		N/A        \r\n	', '', 1, 9),
(24, 'TRADING MANAGEMENT SYSTEM', 13, '	N/A        ', '1503954219041trading.png', '		N/A        \r\n	', '', 1, 9),
(25, 'GIRINKA PROGRAM MANAGEMENT SYSTEM', 13, '	N/A        ', '1503954465058girinka.jpg', '	N/A                ', '', 1, 11),
(26, 'GIRINKA PROGRAM MANAGEMENT SYSTEM', 13, '	N/A        ', 'logo.png', '	N/A                ', '1', 1, 11),
(27, 'GIRINKA PROGRAM MANAGEMENT SYSTEM', 13, '169.254.230.159:9000', 'logo.png', '	N/A                ', '1', 1, 11),
(28, 'Carrier guidance system', 12, '127.0.0.1:10', '1503990233828loading_24.gif', 'This is a software which helps user to measure himself in order to know which carrier is suitable to him/her by passing a simple test which is automatically evaluate him        ', '', 1, 15);

-- --------------------------------------------------------

--
-- Table structure for table `project_assignment`
--

CREATE TABLE IF NOT EXISTS `project_assignment` (
  `id` tinyint(255) NOT NULL,
  `proj_id` tinyint(255) NOT NULL,
  `task_id` tinyint(255) NOT NULL,
  `subtask_id` tinyint(255) NOT NULL,
  `developer_id` tinyint(255) NOT NULL,
  `delete_status` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_assignment`
--

INSERT INTO `project_assignment` (`id`, `proj_id`, `task_id`, `subtask_id`, `developer_id`, `delete_status`, `status`) VALUES
(1, 9, 5, 3, 12, '', 'approved'),
(2, 9, 5, 2, 12, '', 'approved'),
(3, 11, 5, 1, 13, '', 'approved'),
(4, 11, 5, 2, 13, '', 'approved'),
(5, 11, 5, 3, 13, '', 'approved'),
(6, 11, 5, 4, 13, '', 'approved'),
(7, 11, 6, 5, 13, '', 'approved'),
(8, 11, 6, 6, 13, '', 'approved'),
(9, 11, 6, 7, 13, '', 'approved'),
(10, 11, 6, 8, 13, '', 'approved'),
(11, 11, 6, 9, 13, '', 'approved'),
(12, 11, 7, 10, 13, '', 'approved'),
(13, 11, 7, 11, 13, '', 'approved'),
(14, 11, 7, 12, 13, '', 'approved'),
(15, 11, 7, 13, 13, '', 'approved'),
(16, 11, 8, 14, 13, '', 'approved'),
(17, 11, 8, 15, 13, '', 'approved'),
(18, 11, 8, 16, 13, '', 'approved'),
(19, 11, 8, 17, 13, '', 'approved'),
(20, 11, 8, 18, 13, '', 'approved'),
(21, 11, 8, 19, 13, '', 'approved'),
(22, 11, 9, 20, 13, '', 'approved'),
(23, 11, 10, 21, 13, '', 'approved'),
(24, 11, 10, 22, 13, '', 'requested'),
(25, 11, 10, 23, 13, '', 'requested'),
(26, 11, 10, 24, 13, '', 'approved'),
(27, 11, 10, 25, 13, '', 'approved'),
(28, 11, 11, 26, 13, '', 'denied'),
(29, 11, 11, 27, 13, '', 'requested'),
(30, 11, 11, 28, 13, '', 'approved'),
(31, 11, 11, 29, 13, '', 'approved'),
(32, 11, 11, 30, 13, '', 'approved'),
(33, 11, 11, 31, 13, '', 'approved'),
(34, 11, 11, 32, 13, '', 'approved'),
(35, 11, 13, 33, 13, '', 'approved'),
(36, 11, 13, 34, 13, '', 'approved'),
(37, 11, 13, 35, 13, '', 'approved'),
(38, 11, 12, 36, 13, '', 'approved'),
(39, 11, 12, 37, 13, '', 'approved'),
(40, 11, 12, 38, 13, '', 'approved');

-- --------------------------------------------------------

--
-- Table structure for table `sent_debts`
--

CREATE TABLE IF NOT EXISTS `sent_debts` (
  `id` tinyint(255) NOT NULL,
  `sendto` varchar(255) NOT NULL,
  `amount` int(255) NOT NULL,
  `motif` varchar(2550) NOT NULL,
  `doneby_id` tinyint(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `delete_status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `subtasks`
--

CREATE TABLE IF NOT EXISTS `subtasks` (
  `id` bigint(20) NOT NULL,
  `sub_name` varchar(255) DEFAULT NULL,
  `sub_marks` double NOT NULL,
  `complete` int(11) DEFAULT NULL,
  `delete_status` varchar(255) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subtasks`
--

INSERT INTO `subtasks` (`id`, `sub_name`, `sub_marks`, `complete`, `delete_status`, `task_id`) VALUES
(1, 'Technical Investigation', 0, 0, '', 5),
(2, 'Interview', 4, 0, '', 5),
(3, 'Observation', 1.5, 0, '', 5),
(4, 'Documentation', 2, 0, '', 5),
(5, 'User Case Diagram', 4, 0, '', 6),
(6, 'Class Diagram', 4, 0, '', 6),
(7, 'Sequence', 4, 0, '', 6),
(8, 'Activiyty Diagram', 4, 0, '', 6),
(9, 'Database diagram', 4, 0, '', 6),
(10, 'Technical Investigation', 1, 0, '1', 7),
(11, 'Interview ', 2, 0, '', 7),
(12, 'Observation', 1.5, 0, '', 7),
(13, 'Documentation', 2, 0, '', 7),
(14, 'User Case diagram', 4, 0, '', 8),
(15, 'Class Diagram', 4, 0, '', 8),
(16, 'Sequence', 4, 0, '', 8),
(17, 'Activity Diagram', 4, 0, '', 8),
(18, 'Activity Diagram', 4, 0, '', 8),
(19, 'Database Diagram', 4, 0, '', 8),
(20, 'System Design', 10, 0, '', 9),
(21, 'Back End Development', 10, 0, '', 10),
(22, 'Front End Development', 10, 0, '', 10),
(23, 'Dashboard Control ', 10, 0, '', 10),
(24, 'Report Generation', 10, 0, '', 10),
(25, 'System Validation', 10, 0, '', 10),
(26, 'Demo Data Entry', 1, 0, '', 11),
(27, 'Insert', 1, 0, '', 11),
(28, 'Update & Delete', 1, 0, '', 11),
(29, 'System', 1, 0, '', 11),
(30, 'Verify Reports ', 1, 0, '', 11),
(31, 'Validation', 1, 0, '', 11),
(32, 'Check All', 1, 0, '', 11),
(33, 'User Manual', 4, 0, '', 13),
(34, 'System Training', 2, 0, '', 13),
(35, 'Technical Support', 2, 0, '', 13),
(36, 'Database', 2, 0, '', 12),
(37, 'Application Deployment', 2, 0, '', 12),
(38, 'Database Backop', 2, 0, '', 12);

-- --------------------------------------------------------

--
-- Table structure for table `tasks`
--

CREATE TABLE IF NOT EXISTS `tasks` (
  `id` bigint(20) NOT NULL,
  `task_name` varchar(255) DEFAULT NULL,
  `complete` int(11) DEFAULT NULL,
  `delete_status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tasks`
--

INSERT INTO `tasks` (`id`, `task_name`, `complete`, `delete_status`) VALUES
(1, 'System analysis', 20, '1'),
(2, 'Database analysis', 40, '1'),
(3, 'data collection', 90, '1'),
(4, 'Follow up project', -1, '1'),
(5, 'Data Collection', 10, '1'),
(6, 'System Analysis', 20, '1'),
(7, 'Data Collection', 10, ''),
(8, 'System Analysis', 20, ''),
(9, 'System Design', 10, ''),
(10, 'System Development', 40, ''),
(11, 'Testing', 7, ''),
(12, 'Deployment of System', 5, ''),
(13, 'Maintenance ', 8, '');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `dob` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `delete_status` tinyint(1) DEFAULT '0',
  `delete_reason` varchar(255) DEFAULT NULL,
  `done_by` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `first_name`, `last_name`, `role`, `phone`, `dob`, `age`, `email`, `photo`, `username`, `password`, `delete_status`, `delete_reason`, `done_by`) VALUES
(10, 'Admin', 'Administrator', 'Administrator', '0789456789', '22/05/1998', '27', 'admin@gmail.com', '1503948680993latePhoto.jpg', 'admin', 'password', 0, NULL, NULL),
(11, 'Germain', 'Manager', 'Manager', '', '1/1/1900', '', '', '1503949104596picing lie.jpg', 'Mugisha', 'zxcvbn', 0, '', ''),
(12, 'Emile', 'Kwizera', 'Developer', '', '1/1/1900', '', '', '1503948404689bro.jpg', 'Kwizera', 'zxcvbn', 0, '', ''),
(13, 'NSENGUMUREMYI', 'Noel ', 'Developer', '', '24/12/1983', '', '', '', 'noel', 'password', 0, '', ''),
(14, 'Jean D'' Amour', 'MUNYEMANA', 'Client', '', '24/12/1983', '', '', '', 'munyemana', 'password', 0, '', ''),
(15, 'Jea d'' amour', 'MUNYEMANA', 'Client', '', '4/5/1981', '', '', '', 'munyemanax', 'password', 0, '', ''),
(16, 'fati', 'fatima', 'Client', '', '1/1/1900', '', '', '', 'rutagengwa', 'budha12345', 0, '', ''),
(17, 'Eric', 'Twagira', 'Client', '', '1/1/1900', '', '', '', 'Eric', 'zxcvbn', 0, '', ''),
(18, 'Jean Pierre', 'Kabera', 'Client', '', '14/10/1903', '', '', '', 'kabera', 'password', 0, '', ''),
(19, 'Kumar', 'Kumar', 'Client', '', '6/7/1979', '', '', '', 'kumar', 'password', 0, '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cashin`
--
ALTER TABLE `cashin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cashout`
--
ALTER TABLE `cashout`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `covered`
--
ALTER TABLE `covered`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `debts`
--
ALTER TABLE `debts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `details`
--
ALTER TABLE `details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ix_details_project_1` (`project_id`);

--
-- Indexes for table `forums`
--
ALTER TABLE `forums`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `forum_data`
--
ALTER TABLE `forum_data`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ix_messages_sendto_2` (`sendto_id`),
  ADD KEY `ix_messages_fromu_3` (`fromu_id`);

--
-- Indexes for table `owned`
--
ALTER TABLE `owned`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payed`
--
ALTER TABLE `payed`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `play_evolutions`
--
ALTER TABLE `play_evolutions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ix_projects_developer_4` (`developer_id`),
  ADD KEY `ix_projects_depart_5` (`depart_id`);

--
-- Indexes for table `project_assignment`
--
ALTER TABLE `project_assignment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sent_debts`
--
ALTER TABLE `sent_debts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subtasks`
--
ALTER TABLE `subtasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ix_subtasks_task_6` (`task_id`);

--
-- Indexes for table `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cashin`
--
ALTER TABLE `cashin`
  MODIFY `id` tinyint(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `cashout`
--
ALTER TABLE `cashout`
  MODIFY `id` tinyint(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `covered`
--
ALTER TABLE `covered`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `debts`
--
ALTER TABLE `debts`
  MODIFY `id` tinyint(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `details`
--
ALTER TABLE `details`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `forums`
--
ALTER TABLE `forums`
  MODIFY `id` tinyint(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `forum_data`
--
ALTER TABLE `forum_data`
  MODIFY `id` tinyint(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `members`
--
ALTER TABLE `members`
  MODIFY `id` tinyint(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=44;
--
-- AUTO_INCREMENT for table `owned`
--
ALTER TABLE `owned`
  MODIFY `id` tinyint(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `payed`
--
ALTER TABLE `payed`
  MODIFY `id` tinyint(255) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `projects`
--
ALTER TABLE `projects`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `project_assignment`
--
ALTER TABLE `project_assignment`
  MODIFY `id` tinyint(255) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `sent_debts`
--
ALTER TABLE `sent_debts`
  MODIFY `id` tinyint(255) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `subtasks`
--
ALTER TABLE `subtasks`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=39;
--
-- AUTO_INCREMENT for table `tasks`
--
ALTER TABLE `tasks`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `details`
--
ALTER TABLE `details`
  ADD CONSTRAINT `fk_details_project_1` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`);

--
-- Constraints for table `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `fk_messages_fromu_3` FOREIGN KEY (`fromu_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `fk_messages_sendto_2` FOREIGN KEY (`sendto_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `projects`
--
ALTER TABLE `projects`
  ADD CONSTRAINT `fk_projects_depart_5` FOREIGN KEY (`depart_id`) REFERENCES `department` (`id`),
  ADD CONSTRAINT `fk_projects_developer_4` FOREIGN KEY (`developer_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `subtasks`
--
ALTER TABLE `subtasks`
  ADD CONSTRAINT `fk_subtasks_task_6` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

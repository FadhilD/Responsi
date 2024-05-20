-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2024 at 09:38 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `zoo`
--

-- --------------------------------------------------------

--
-- Table structure for table `hewan`
--

CREATE TABLE `hewan` (
  `id` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `kelas` varchar(15) NOT NULL,
  `jenis_makanan` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hewan`
--

INSERT INTO `hewan` (`id`, `nama`, `kelas`, `jenis_makanan`) VALUES
(1, 'Singa', 'mamalia', 'karnivora'),
(2, 'Kucing', 'mamalia', 'omnivora'),
(3, 'Bebek', 'burung', 'omnivora'),
(4, 'Jerapah', 'mamalia', 'herbivora'),
(5, 'Gajah', 'mamalia', 'herbivora'),
(6, 'Pinguin', 'burung', 'karnivora'),
(7, 'Ular', 'reptil', 'karnivora'),
(8, 'Buaya', 'reptil', 'karnivora'),
(9, 'Harimau', 'mamalia', 'karnivora'),
(10, 'Orang utan', 'mamalia', 'omnivora');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id` int(11) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id`, `nama`, `email`, `password`, `role`) VALUES
(1, 'Yanto', 'yanto@gmai.com', '123', 'admin'),
(2, 'Chello', 'rafli@gmai.com', '123', 'admin'),
(3, 'Juan', 'juan@gmai.com', '123', 'admin'),
(4, 'Alfi', 'alfi@gmai.com', '321', 'pegawai'),
(5, 'Delphi', 'delphi@gmai.com', '321', 'pegawai'),
(6, 'Chandra', 'chandra@gmai.com', '321', 'pegawai'),
(7, 'Bram', 'bram@gmai.com', '321', 'pegawai'),
(8, 'fadhil', 'fadhil@gmai.com', '321', 'pegawai'),
(9, 'Iqbal', 'iqbal@gmai.com', '321', 'pegawai'),
(10, 'Putra', 'putra@gmai.com', '321', 'pegawai'),
(11, 'Rafiq', 'rafiq@gmai.com', '321', 'pegawai');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hewan`
--
ALTER TABLE `hewan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hewan`
--
ALTER TABLE `hewan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `pegawai`
--
ALTER TABLE `pegawai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

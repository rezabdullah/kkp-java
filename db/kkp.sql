-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 06 Jun 2021 pada 16.32
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kkp`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id` int(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `no_hp` varchar(20) NOT NULL,
  `role` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`, `fullname`, `email`, `no_hp`, `role`) VALUES
(1, 'admin', 'admin', 'Reza Abdulah', 'ini.email@gmail.com', '08123456789', 'Super Admin'),
(2, 'reza', 'pssword', 'Reza Abdulah', 'reza.abdullah@gmail.com', '0812345678910', 'Super Admin'),
(3, 'test', 'test', 'test', 'ini.email@gmail.com', '08123456789', 'Admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE `customer` (
  `id` int(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `address` text NOT NULL,
  `telp` varchar(25) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`id`, `nama`, `address`, `telp`, `email`) VALUES
(1, 'Reza Abulah Reza', 'Pondok Ranggon', '0812345678910', 'ini.email@gmail.com');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pack`
--

CREATE TABLE `pack` (
  `id` int(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `harga` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pack`
--

INSERT INTO `pack` (`id`, `nama`, `harga`) VALUES
(1, 'kayu', 50000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `shipping`
--

CREATE TABLE `shipping` (
  `id` int(20) NOT NULL,
  `id_sender` int(20) NOT NULL,
  `recipient_name` varchar(255) NOT NULL,
  `recipient_address` text NOT NULL,
  `recipient_phone` varchar(20) NOT NULL,
  `item_name` text NOT NULL,
  `item_weight` int(10) NOT NULL,
  `item_qty` int(10) NOT NULL,
  `id_pack` int(10) NOT NULL,
  `ship_type` varchar(255) NOT NULL,
  `pack_qty` int(10) NOT NULL,
  `amount` int(20) NOT NULL,
  `payment_status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `shipping`
--

INSERT INTO `shipping` (`id`, `id_sender`, `recipient_name`, `recipient_address`, `recipient_phone`, `item_name`, `item_weight`, `item_qty`, `id_pack`, `ship_type`, `pack_qty`, `amount`, `payment_status`) VALUES
(1, 1, 'Abdullah Reza', 'jalan jambore kp pondok ranggon gg jambu, Harjamukti Cimanggis Depok Jawa Barat', '321321321321', 'Mesin pesawat jet', 10, 1, 1, 'express', 1, 100000, 'paid'),
(7, 1, 'Nur Kholis', 'Jayapura', '123123123123', 'Meja Kayu', 5, 10, 1, 'regular', 5, 500000, 'unpaid');

-- --------------------------------------------------------

--
-- Struktur dari tabel `shipping_detail`
--

CREATE TABLE `shipping_detail` (
  `id` int(10) NOT NULL,
  `id_shipping` int(20) NOT NULL,
  `officer` varchar(255) NOT NULL,
  `status` varchar(50) NOT NULL,
  `note` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `shipping_detail`
--

INSERT INTO `shipping_detail` (`id`, `id_shipping`, `officer`, `status`, `note`) VALUES
(1, 1, '1', 'receiving', 'lorem ipsum dolor sit amet'),
(4, 1, '1', 'delivered', 'sudah dikirim'),
(5, 1, '1', 'drop point', 'drop point'),
(6, 7, '1', 'receiving', 'dikirim'),
(9, 7, '1', 'drop point', 'sampai di bali'),
(10, 7, '1', 'delivered', 'sampai di jayapura');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `pack`
--
ALTER TABLE `pack`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `shipping`
--
ALTER TABLE `shipping`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `shipping_detail`
--
ALTER TABLE `shipping_detail`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `pack`
--
ALTER TABLE `pack`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `shipping`
--
ALTER TABLE `shipping`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `shipping_detail`
--
ALTER TABLE `shipping_detail`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

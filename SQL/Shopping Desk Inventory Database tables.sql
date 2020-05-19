CREATE TABLE `admin` (
  `AID` char(15) DEFAULT NULL,
  `Apassword` char(14) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `attendance_details` (
  `Serial_No` int(11) NOT NULL,
  `Emp_ID` char(50) NOT NULL,
  `Emp_Name` char(50) NOT NULL,
  `Date` char(60) NOT NULL,
  `Present_or_Absent` char(15) NOT NULL,
  UNIQUE KEY `Serial_No` (`Serial_No`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `employee_details` (
  `emp_ID` char(50) NOT NULL,
  `First_name` char(20) NOT NULL,
  `Mid_name` char(20) DEFAULT NULL,
  `Last_name` char(20) NOT NULL,
  `Gender` char(100) DEFAULT NULL,
  `DOB` char(50) NOT NULL,
  `DOJ` char(50) NOT NULL,
  `Addr` char(150) NOT NULL,
  `Mob` char(20) NOT NULL,
  `Email` char(50) NOT NULL,
  `Basic_sal` double NOT NULL,
  PRIMARY KEY (`emp_ID`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `items_details` (
  `item_code` char(30) NOT NULL,
  `item_name` char(30) NOT NULL,
  `manufacture_date` char(50) DEFAULT NULL,
  `expired_date` char(50) DEFAULT NULL,
  `purchase_rate` float NOT NULL,
  `sale_rate` float NOT NULL,
  `disscription` char(100) DEFAULT NULL,
  PRIMARY KEY (`item_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `purchase_details` (
  `purchase_ID` char(40) NOT NULL,
  `purchase_date` char(50) DEFAULT NULL,
  `supplier_id` char(30) NOT NULL,
  `supplier_name` char(30) NOT NULL,
  `item_code` char(40) NOT NULL,
  `item_name` char(40) NOT NULL,
  `quantity` float NOT NULL,
  `rate` float NOT NULL,
  `amt` float NOT NULL,
  `sgst` float NOT NULL,
  `cgst` float NOT NULL,
  `total_amt` float NOT NULL,
  PRIMARY KEY (`purchase_ID`),
  UNIQUE KEY `item_code` (`item_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `purchase_return_details` (
  `return_no` char(50) NOT NULL,
  `return_date` char(50) NOT NULL,
  `supplier_ID` char(50) NOT NULL,
  `supplier_name` char(40) NOT NULL,
  `purchase_ID` char(50) NOT NULL,
  `purchase_date` char(50) NOT NULL,
  `item_code` char(50) NOT NULL,
  `item_name` char(50) NOT NULL,
  `quantity` float NOT NULL,
  `rate` float NOT NULL,
  `amt` float NOT NULL,
  `sgst` float NOT NULL,
  `cgst` float NOT NULL,
  `total_amt` float NOT NULL,
  PRIMARY KEY (`item_code`),
  UNIQUE KEY `return_no` (`return_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sales_details` (
  `sale_num` int(11) NOT NULL,
  `sale_date` char(50) DEFAULT NULL,
  `item_code` char(15) NOT NULL,
  `item_name` char(20) NOT NULL,
  `quantity` float NOT NULL,
  `rate` float NOT NULL,
  `amt` float NOT NULL,
  `sgst` float NOT NULL,
  `cgst` float NOT NULL,
  `cons_amt` int(11) DEFAULT NULL,
  `total_amt` float NOT NULL,
  PRIMARY KEY (`item_code`),
  UNIQUE KEY `sale_num` (`sale_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sales_return_details` (
  `sale_num` int(11) NOT NULL,
  `sale_date` char(50) DEFAULT NULL,
  `return_date` char(50) DEFAULT NULL,
  `item_code` char(20) NOT NULL,
  `item_name` char(20) NOT NULL,
  `return_num_item` float NOT NULL,
  `rate` float NOT NULL,
  `amt` float NOT NULL,
  `sgst` float NOT NULL,
  `cgst` float NOT NULL,
  `total_return_amt` float NOT NULL,
  `return_reason` char(155) NOT NULL,
  PRIMARY KEY (`item_code`),
  UNIQUE KEY `sale_num` (`sale_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `supplier_details` (
  `supplier_ID` char(30) NOT NULL,
  `supplier_name` char(30) NOT NULL,
  `mob_number` int(11) NOT NULL,
  `H_no` char(30) NOT NULL,
  `street_lane` char(30) NOT NULL,
  `city` char(30) NOT NULL,
  `state` char(30) NOT NULL,
  `pin_code` int(11) NOT NULL,
  PRIMARY KEY (`supplier_ID`),
  UNIQUE KEY `mob_number` (`mob_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


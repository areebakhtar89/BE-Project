USE [master]
GO
/****** Object:  Database [Locationbased_Ads_db]    Script Date: 30-01-2020 17:32:49 ******/
CREATE DATABASE [Locationbased_Ads_db]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Locationbased_Ads_db', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\Locationbased_Ads_db.mdf' , SIZE = 8192KB , MAXSIZE = 5242880KB , FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Locationbased_Ads_db_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\Locationbased_Ads_db_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [Locationbased_Ads_db] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Locationbased_Ads_db].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Locationbased_Ads_db] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET ARITHABORT OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Locationbased_Ads_db] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Locationbased_Ads_db] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Locationbased_Ads_db] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Locationbased_Ads_db] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Locationbased_Ads_db] SET  MULTI_USER 
GO
ALTER DATABASE [Locationbased_Ads_db] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Locationbased_Ads_db] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Locationbased_Ads_db] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Locationbased_Ads_db] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Locationbased_Ads_db] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Locationbased_Ads_db]
GO
/****** Object:  User [Locationbased_Ads_db]    Script Date: 30-01-2020 17:32:50 ******/
CREATE USER [Locationbased_Ads_db] FOR LOGIN [Locationbased_Ads_db] WITH DEFAULT_SCHEMA=[Locationbased_Ads_db]
GO
ALTER ROLE [db_ddladmin] ADD MEMBER [Locationbased_Ads_db]
GO
ALTER ROLE [db_backupoperator] ADD MEMBER [Locationbased_Ads_db]
GO
ALTER ROLE [db_datareader] ADD MEMBER [Locationbased_Ads_db]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [Locationbased_Ads_db]
GO
/****** Object:  Schema [Locationbased_Ads_db]    Script Date: 30-01-2020 17:32:52 ******/
CREATE SCHEMA [Locationbased_Ads_db]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 30-01-2020 17:32:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[admin_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](max) NULL,
	[password] [nvarchar](max) NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[admin_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[category_master]    Script Date: 30-01-2020 17:32:53 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category_master](
	[cat_id] [bigint] IDENTITY(1,1) NOT NULL,
	[category] [nvarchar](max) NULL,
 CONSTRAINT [PK_category_master] PRIMARY KEY CLUSTERED 
(
	[cat_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[customer_master]    Script Date: 30-01-2020 17:32:53 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customer_master](
	[customer_id] [int] IDENTITY(1,1) NOT NULL,
	[custname] [nvarchar](max) NULL,
	[custemail] [nvarchar](max) NULL,
	[custcontact] [nvarchar](max) NULL,
	[custlocation] [nvarchar](max) NULL,
	[custpassword] [nvarchar](max) NULL,
	[custrepassword] [nvarchar](max) NULL,
 CONSTRAINT [PK_customer_master] PRIMARY KEY CLUSTERED 
(
	[customer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[offer_details]    Script Date: 30-01-2020 17:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[offer_details](
	[offer_id] [int] IDENTITY(1,1) NOT NULL,
	[vendor_id] [int] NULL,
	[offname] [nvarchar](max) NULL,
	[price] [nvarchar](max) NULL,
	[offprice] [nvarchar](max) NULL,
	[offdescription] [nvarchar](max) NULL,
	[offstartdate] [date] NULL,
	[offlastdate] [date] NULL,
	[image] [nvarchar](max) NULL,
 CONSTRAINT [PK_offer_details] PRIMARY KEY CLUSTERED 
(
	[offer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[rating]    Script Date: 30-01-2020 17:32:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[rating](
	[rate_id] [bigint] IDENTITY(1,1) NOT NULL,
	[user_id] [bigint] NULL,
	[vendor_id] [bigint] NULL,
	[rate] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[rate_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Registered_offer]    Script Date: 30-01-2020 17:32:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Registered_offer](
	[off_regis_id] [int] IDENTITY(1,1) NOT NULL,
	[customer_id] [int] NULL,
	[vendor_id] [int] NULL,
	[offer_id] [int] NULL,
	[offname] [nvarchar](max) NULL,
	[offdescription] [nvarchar](max) NULL,
 CONSTRAINT [PK_Registered_offer] PRIMARY KEY CLUSTERED 
(
	[off_regis_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[vendor_master]    Script Date: 30-01-2020 17:32:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[vendor_master](
	[vendor_id] [int] IDENTITY(1,1) NOT NULL,
	[vname] [nvarchar](max) NULL,
	[vcontact] [nvarchar](max) NULL,
	[vlocation] [nvarchar](max) NULL,
	[vdescription] [nvarchar](max) NULL,
	[vemail] [nvarchar](max) NULL,
	[vpassword] [nvarchar](max) NULL,
	[vlongitude] [nvarchar](max) NULL,
	[vlatitude] [nvarchar](max) NULL,
	[cat_id] [int] NULL,
 CONSTRAINT [PK_vendor_master] PRIMARY KEY CLUSTERED 
(
	[vendor_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Admin] ON 

INSERT [dbo].[Admin] ([admin_id], [username], [password]) VALUES (1, N'admin', N'admin')
SET IDENTITY_INSERT [dbo].[Admin] OFF
SET IDENTITY_INSERT [dbo].[category_master] ON 

INSERT [dbo].[category_master] ([cat_id], [category]) VALUES (1, N'milk')
INSERT [dbo].[category_master] ([cat_id], [category]) VALUES (2, N'cold_drink')
INSERT [dbo].[category_master] ([cat_id], [category]) VALUES (3, N'snacks')
INSERT [dbo].[category_master] ([cat_id], [category]) VALUES (4, N'sweets')
INSERT [dbo].[category_master] ([cat_id], [category]) VALUES (5, N'coffee')
SET IDENTITY_INSERT [dbo].[category_master] OFF
SET IDENTITY_INSERT [dbo].[customer_master] ON 

INSERT [dbo].[customer_master] ([customer_id], [custname], [custemail], [custcontact], [custlocation], [custpassword], [custrepassword]) VALUES (1, N'xyz', N'xyz@gmail.com', N'7894561230', N'malad', N'1234', N'1234')
INSERT [dbo].[customer_master] ([customer_id], [custname], [custemail], [custcontact], [custlocation], [custpassword], [custrepassword]) VALUES (2, N'abc', N'abc@gmail.com', N'7896541230', N'Mumbai', N'1234', N'1234')
INSERT [dbo].[customer_master] ([customer_id], [custname], [custemail], [custcontact], [custlocation], [custpassword], [custrepassword]) VALUES (3, N'Vaibhav', N'vaibhav.aher1@gmail.com', N'8997905880', N'abcd', N'Happy2019', N'Happy2019')
INSERT [dbo].[customer_master] ([customer_id], [custname], [custemail], [custcontact], [custlocation], [custpassword], [custrepassword]) VALUES (4, N'Keval', N'kevaljoshi0335@gmail.com', N'7575064043', N'ifsc, Dublin 1, Dublin, Ireland', N'12345', N'12345')
INSERT [dbo].[customer_master] ([customer_id], [custname], [custemail], [custcontact], [custlocation], [custpassword], [custrepassword]) VALUES (5, N'keval', N'keval.joshi0143@gmail.com', N'9899665864', N'dublin', N'12345', N'12345')
SET IDENTITY_INSERT [dbo].[customer_master] OFF
SET IDENTITY_INSERT [dbo].[offer_details] ON 

INSERT [dbo].[offer_details] ([offer_id], [vendor_id], [offname], [price], [offprice], [offdescription], [offstartdate], [offlastdate], [image]) VALUES (2, 8, N'sprit200ml', NULL, N'30', N'50 % off', CAST(N'2019-02-11' AS Date), CAST(N'2020-02-20' AS Date), N'images/soil.jpg')
INSERT [dbo].[offer_details] ([offer_id], [vendor_id], [offname], [price], [offprice], [offdescription], [offstartdate], [offlastdate], [image]) VALUES (3, 8, N'milk superm', NULL, N'10', N'20 % of', CAST(N'2019-02-12' AS Date), CAST(N'2020-02-20' AS Date), N'images/soil.jpg')
INSERT [dbo].[offer_details] ([offer_id], [vendor_id], [offname], [price], [offprice], [offdescription], [offstartdate], [offlastdate], [image]) VALUES (4, 11, N'sssssssppppp', NULL, N'5', N'ygy', CAST(N'2019-11-14' AS Date), CAST(N'2020-02-20' AS Date), N'images/soil.jpg')
INSERT [dbo].[offer_details] ([offer_id], [vendor_id], [offname], [price], [offprice], [offdescription], [offstartdate], [offlastdate], [image]) VALUES (5, 9, N'pepsi', NULL, N'60', N'10% off', CAST(N'2019-11-13' AS Date), CAST(N'2020-02-20' AS Date), N'images/soil.jpg')
INSERT [dbo].[offer_details] ([offer_id], [vendor_id], [offname], [price], [offprice], [offdescription], [offstartdate], [offlastdate], [image]) VALUES (6, 9, N'snacks with cold drink ', NULL, N'55', N'one free', CAST(N'2019-11-17' AS Date), CAST(N'2020-02-20' AS Date), N'images/soil.jpg')
SET IDENTITY_INSERT [dbo].[offer_details] OFF
SET IDENTITY_INSERT [dbo].[rating] ON 

INSERT [dbo].[rating] ([rate_id], [user_id], [vendor_id], [rate]) VALUES (1, 1, 8, 4)
INSERT [dbo].[rating] ([rate_id], [user_id], [vendor_id], [rate]) VALUES (2, 1, 9, 2)
INSERT [dbo].[rating] ([rate_id], [user_id], [vendor_id], [rate]) VALUES (3, 4, 8, 2)
SET IDENTITY_INSERT [dbo].[rating] OFF
SET IDENTITY_INSERT [dbo].[Registered_offer] ON 

INSERT [dbo].[Registered_offer] ([off_regis_id], [customer_id], [vendor_id], [offer_id], [offname], [offdescription]) VALUES (1, 1, NULL, 2, N'discountoffer', N'buy1 get 1')
INSERT [dbo].[Registered_offer] ([off_regis_id], [customer_id], [vendor_id], [offer_id], [offname], [offdescription]) VALUES (2, 1, NULL, 3, N'discountoffer1', N'new style shoe1')
INSERT [dbo].[Registered_offer] ([off_regis_id], [customer_id], [vendor_id], [offer_id], [offname], [offdescription]) VALUES (3, 1, NULL, 1004, N'jogeshoffer', N'jogeshofferdesc')
INSERT [dbo].[Registered_offer] ([off_regis_id], [customer_id], [vendor_id], [offer_id], [offname], [offdescription]) VALUES (4, 1, NULL, 1008, N'Anu', N'MAss')
INSERT [dbo].[Registered_offer] ([off_regis_id], [customer_id], [vendor_id], [offer_id], [offname], [offdescription]) VALUES (5, 1, NULL, 1009, N'Anu 1', N'FooD')
INSERT [dbo].[Registered_offer] ([off_regis_id], [customer_id], [vendor_id], [offer_id], [offname], [offdescription]) VALUES (6, 3, NULL, 1008, N'Anu', N'MAss')
INSERT [dbo].[Registered_offer] ([off_regis_id], [customer_id], [vendor_id], [offer_id], [offname], [offdescription]) VALUES (7, 3, NULL, 1009, N'Anu 1', N'FooD')
INSERT [dbo].[Registered_offer] ([off_regis_id], [customer_id], [vendor_id], [offer_id], [offname], [offdescription]) VALUES (8, 3, NULL, 2, N'Milk', N'buy1 get 1')
INSERT [dbo].[Registered_offer] ([off_regis_id], [customer_id], [vendor_id], [offer_id], [offname], [offdescription]) VALUES (9, 1, NULL, 1006, N'Trekking Shoes', N'Woodland Trekking shoes')
INSERT [dbo].[Registered_offer] ([off_regis_id], [customer_id], [vendor_id], [offer_id], [offname], [offdescription]) VALUES (10, 1, NULL, 1010, N'new offer', N'best offer')
INSERT [dbo].[Registered_offer] ([off_regis_id], [customer_id], [vendor_id], [offer_id], [offname], [offdescription]) VALUES (11, 1, NULL, 1011, N'new offer1', N'best offer1')
INSERT [dbo].[Registered_offer] ([off_regis_id], [customer_id], [vendor_id], [offer_id], [offname], [offdescription]) VALUES (12, 3, NULL, 1007, N'ZARA', N'Trousers')
INSERT [dbo].[Registered_offer] ([off_regis_id], [customer_id], [vendor_id], [offer_id], [offname], [offdescription]) VALUES (13, 1, NULL, 1007, N'ZARA', N'Trousers')
SET IDENTITY_INSERT [dbo].[Registered_offer] OFF
SET IDENTITY_INSERT [dbo].[vendor_master] ON 

INSERT [dbo].[vendor_master] ([vendor_id], [vname], [vcontact], [vlocation], [vdescription], [vemail], [vpassword], [vlongitude], [vlatitude], [cat_id]) VALUES (8, N'MR.shiv', N'0899665864', N'malad', N'FooD', N'anandlodha44@gmail.com', N'kval', N'72.8484', N'19.1874', 1)
INSERT [dbo].[vendor_master] ([vendor_id], [vname], [vcontact], [vlocation], [vdescription], [vemail], [vpassword], [vlongitude], [vlatitude], [cat_id]) VALUES (9, N'MR.jayprakash', N'0899665864', N'IFSC', N'Edu', N'kevaljoshi03@gmail.com', N'kval', N'72.8526', N'19.1663', 2)
INSERT [dbo].[vendor_master] ([vendor_id], [vname], [vcontact], [vlocation], [vdescription], [vemail], [vpassword], [vlongitude], [vlatitude], [cat_id]) VALUES (11, N'xyz', N'9632587410', N'malad', N'50 % off', N'xyz@gmail.com', N'12345', N'72.8484', N'19.1874', 4)
INSERT [dbo].[vendor_master] ([vendor_id], [vname], [vcontact], [vlocation], [vdescription], [vemail], [vpassword], [vlongitude], [vlatitude], [cat_id]) VALUES (12, N'mahalakshmi shop', N'7894561230', N'goregaon', N'All type of snacks ', N'maha@gmail.com', N'1234', N'72.8526', N'19.1663', 3)
SET IDENTITY_INSERT [dbo].[vendor_master] OFF
USE [master]
GO
ALTER DATABASE [Locationbased_Ads_db] SET  READ_WRITE 
GO

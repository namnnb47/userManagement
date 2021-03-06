USE [master]
GO
/****** Object:  Database [Lab1]    Script Date: 23/8/2020 3:29:15 PM ******/
CREATE DATABASE [Lab1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Lab1', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Lab1.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Lab1_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Lab1_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Lab1] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Lab1].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Lab1] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Lab1] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Lab1] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Lab1] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Lab1] SET ARITHABORT OFF 
GO
ALTER DATABASE [Lab1] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Lab1] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Lab1] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Lab1] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Lab1] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Lab1] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Lab1] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Lab1] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Lab1] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Lab1] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Lab1] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Lab1] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Lab1] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Lab1] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Lab1] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Lab1] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Lab1] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Lab1] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Lab1] SET  MULTI_USER 
GO
ALTER DATABASE [Lab1] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Lab1] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Lab1] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Lab1] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Lab1] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Lab1]
GO
/****** Object:  Table [dbo].[tbl_Promotion]    Script Date: 23/8/2020 3:29:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Promotion](
	[username] [nvarchar](50) NOT NULL,
	[rank] [int] NULL,
	[date] [date] NULL,
 CONSTRAINT [PK_tbl_Promotion] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbl_Role]    Script Date: 23/8/2020 3:29:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_Role](
	[roleID] [int] NOT NULL,
	[roleName] [varchar](50) NULL,
 CONSTRAINT [PK_tbl_Role] PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_User]    Script Date: 23/8/2020 3:29:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_User](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[fullname] [nvarchar](50) NULL,
	[roleID] [int] NOT NULL,
	[email] [nvarchar](50) NULL,
	[phone] [nvarchar](50) NULL,
	[photo] [nvarchar](200) NULL,
	[status] [nvarchar](50) NULL,
 CONSTRAINT [PK_tbl_User] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[tbl_Promotion] ([username], [rank], [date]) VALUES (N'bn', 5, CAST(N'2020-08-23' AS Date))
INSERT [dbo].[tbl_Promotion] ([username], [rank], [date]) VALUES (N'nam', 7, CAST(N'2020-08-22' AS Date))
INSERT [dbo].[tbl_Role] ([roleID], [roleName]) VALUES (1, N'Admin')
INSERT [dbo].[tbl_Role] ([roleID], [roleName]) VALUES (2, N'User')
INSERT [dbo].[tbl_Role] ([roleID], [roleName]) VALUES (3, N'Stub')
INSERT [dbo].[tbl_User] ([username], [password], [fullname], [roleID], [email], [phone], [photo], [status]) VALUES (N'bn', N'pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM=', N'bac nam', 1, N'bacnam@gmail.com', N'1234567890', N'C:\Users\Admin\Desktop\106923124_3734928679855471_2119490095963333396_o.jpg', N'Active')
INSERT [dbo].[tbl_User] ([username], [password], [fullname], [roleID], [email], [phone], [photo], [status]) VALUES (N'nam', N'pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM=', N'namnnb47', 1, N'namnnb47@gmail.com', N'0938484001', N'C:\Users\Admin\Desktop\116790096_339052574117435_6762491446789249376_o.jpg', N'Inactive')
INSERT [dbo].[tbl_User] ([username], [password], [fullname], [roleID], [email], [phone], [photo], [status]) VALUES (N'user1', N'pmWkWSBCL51Bfkhn79xPuKBKHz//H6B+mY6G9/eieuM=', N'user1', 2, N'user1@gmail.com', N'0938484001', N'C:\fakepath\117089348_339052544117438_7042340556235900307_o.jpg', N'Inactive')
ALTER TABLE [dbo].[tbl_Promotion]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Promotion_tbl_User] FOREIGN KEY([username])
REFERENCES [dbo].[tbl_User] ([username])
GO
ALTER TABLE [dbo].[tbl_Promotion] CHECK CONSTRAINT [FK_tbl_Promotion_tbl_User]
GO
ALTER TABLE [dbo].[tbl_User]  WITH CHECK ADD  CONSTRAINT [FK_tbl_User_tbl_Role] FOREIGN KEY([roleID])
REFERENCES [dbo].[tbl_Role] ([roleID])
GO
ALTER TABLE [dbo].[tbl_User] CHECK CONSTRAINT [FK_tbl_User_tbl_Role]
GO
USE [master]
GO
ALTER DATABASE [Lab1] SET  READ_WRITE 
GO

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AdminLTE 3 | Dashboard</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <link rel="stylesheet" href="<c:url value="/admin/plugins/fontawesome-free/css/all.min.css"/>">

    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Tempusdominus Bootstrap 4 -->
    <link rel="stylesheet"
          href="<c:url value="/admin/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/admin/dist/css/adminlte.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/admin/plugins/overlayScrollbars/css/OverlayScrollbars.min.css"/>">

    <%--    <link rel="stylesheet" href="../../plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">--%>
    <link rel="stylesheet" href="<c:url value="/admin/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css"/>">
    <%--    <link rel="stylesheet" href="../../plugins/datatables-responsive/css/responsive.bootstrap4.min.css">--%>
    <link rel="stylesheet"
          href="<c:url value="/admin/plugins/datatables-responsive/css/responsive.bootstrap4.min.css"/>">
    <%--    <link rel="stylesheet" href="../../plugins/datatables-buttons/css/buttons.bootstrap4.min.css">--%>
    <link rel="stylesheet" href="<c:url value="/admin/plugins/datatables-buttons/css/buttons.bootstrap4.min.css"/>">


</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

    <!-- Preloader -->
    <div class="preloader flex-column justify-content-center align-items-center">
        <img class="animation__shake" src="<c:url value="/admin/dist/img/AdminLTELogo.png"/>" alt="AdminLTELogo"
             height="60"
             width="60">
    </div>

    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Home</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Contact</a>
            </li>
        </ul>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <!-- Navbar Search -->
            <li class="nav-item">
                <a class="nav-link" data-widget="navbar-search" href="#" role="button">
                    <i class="fas fa-search"></i>
                </a>
                <div class="navbar-search-block">
                    <form class="form-inline">
                        <div class="input-group input-group-sm">
                            <input class="form-control form-control-navbar" type="search" placeholder="Search"
                                   aria-label="Search">
                            <div class="input-group-append">
                                <button class="btn btn-navbar" type="submit">
                                    <i class="fas fa-search"></i>
                                </button>
                                <button class="btn btn-navbar" type="button" data-widget="navbar-search">
                                    <i class="fas fa-times"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </li>

            <!-- Messages Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-comments"></i>
                    <span class="badge badge-danger navbar-badge">3</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="<c:url value="/admin/dist/img/user1-128x128.jpg"/>" alt="User Avatar"
                                 class="img-size-50 mr-3 img-circle">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Brad Diesel
                                    <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">Call me whenever you can...</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="<c:url value="/admin/dist/img/user8-128x128.jpg"/>" alt="User Avatar"
                                 class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    John Pierce
                                    <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">I got your message bro</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="<c:url value="/admin/dist/img/user3-128x128.jpg"/>" alt="User Avatar"
                                 class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Nora Silvester
                                    <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">The subject goes here</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
                </div>
            </li>
            <!-- Notifications Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-bell"></i>
                    <span class="badge badge-warning navbar-badge">15</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <span class="dropdown-item dropdown-header">15 Notifications</span>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-envelope mr-2"></i> 4 new messages
                        <span class="float-right text-muted text-sm">3 mins</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-users mr-2"></i> 8 friend requests
                        <span class="float-right text-muted text-sm">12 hours</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-file mr-2"></i> 3 new reports
                        <span class="float-right text-muted text-sm">2 days</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="fullscreen" href="#" role="button">
                    <i class="fas fa-expand-arrows-alt"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="control-sidebar" data-controlsidebar-slide="true" href="#"
                   role="button">
                    <i class="fas fa-th-large"></i>
                </a>
            </li>
        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="#" class="brand-link">
            <img src="<c:url value="/admin/dist/img/AdminLTELogo.png"/>" alt="AdminLTE Logo"
                 class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-light">AdminLTE 3</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user panel (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="<c:url value="/admin/dist/img/user2-160x160.jpg"/>" class="img-circle elevation-2"
                         alt="User Image">
                </div>
                <div class="info">
                    <a href="#" class="d-block">Alexander Pierce</a>
                </div>
            </div>

            <!-- SidebarSearch Form -->
            <div class="form-inline">
                <div class="input-group" data-widget="sidebar-search">
                    <input class="form-control form-control-sidebar" type="search" placeholder="Search"
                           aria-label="Search">
                    <div class="input-group-append">
                        <button class="btn btn-sidebar">
                            <i class="fas fa-search fa-fw"></i>
                        </button>
                    </div>
                </div>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                    data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->
                    <li class="nav-item menu-open">
                        <a href="#" class="nav-link active">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                Dashboard
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="<c:url value="/admin/user"/>" class="nav-link active">
                                    <i class="fas fa-user nav-icon"></i>
                                    <p>Quản lý khách hàng</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="<c:url value="/admin/cate"/>" class="nav-link">
                                    <i class="fas fa-list nav-icon"></i>
                                    <p>Quản lý danh mục</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="<c:url value="/admin/food"/>" class="nav-link">
                                    <i class="fas fa-birthday-cake nav-icon"></i>
                                    <p>Quản lý món ăn</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>


    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Nhân sự</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Khách hàng</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">

                        <div class="card">
                            <div class="card-header"
                                 style="display: flex;align-items: center;justify-content: space-between">
                                <h3 class="card-title">Quản lý nhân sự</h3>
                                <button type="button" class="btn btn-success" style="margin-left: auto"
                                        data-toggle="modal" data-target="#cateUser">Thêm nhân sự
                                </button>
                                <div class="modal fade" id="cateUser" tabindex="-1" role="dialog"
                                     aria-labelledby="cateUserLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="cateUserLabel">Thêm khách hàng</h5>
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <form action="${request.contextPath}/addUser" method="post">
 													<div class="card-body">
                                                        <div class="form-group">
                                                            <label for="exampleInputEmail1">Email address</label>
                                                            <input type="email" class="form-control"
                                                                   id="exampleInputEmail1" placeholder="Enter email"
                                                            name="email">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="exampleInputPassword1">Password</label>
                                                            <input type="password" class="form-control"
                                                                   id="exampleInputPassword1" placeholder="Password"
                                                            name="password">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="name">Name</label>
                                                            <input type="text" class="form-control"
                                                                   id="name" placeholder="Name"
                                                            name="username">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="phone">phone</label>
                                                            <input type="text" class="form-control"
                                                                   id="phone" placeholder="09232142321"
                                                            name="phone">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="address">Address</label>
                                                            <input type="text" class="form-control"
                                                                   id="address" placeholder="TP.HCM"
                                                            name="address">
                                                        </div>

                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary"
                                                                data-dismiss="modal">Đóng
                                                        </button>
                                                        <div class=Submit>
                                                            <button type="submit" class="btn btn-danger">Lưu</button>
                                                        </div>

                                                    </div>
                                                </form>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="example1" class="table table-bordered table-striped table-hover">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Email</th>
                                        <th>Phone</th>
                                        <th>Address</th>
                                        <th>Role</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="user" items="${listUser}">
                                        <tr>
                                            <td><c:out value="${user.id}"/></td>
                                            <td><c:out value="${user.name}"/></td>
                                            <td><c:out value="${user.email}"/></td>
                                            <td><c:out value="${user.phone}"/></td>
                                            <td><c:out value="${user.address}"/></td>
                                            <td><c:out value="${user.role}"/></td>
                                            <td>
                                                <div style="display:flex;align-items: center;justify-content: space-around;margin-top: 5px">
                                                    <a class="fas fa-pencil-alt"
                                                       style="color: black;cursor: pointer" data-toggle="modal" data-target="#userInfo<c:out value="${user.id}"/>"></a>
                                                    <div class="modal fade" id="userInfo<c:out value="${user.id}"/>" tabindex="-1" role="dialog"
                                                         aria-labelledby="userLabel<c:out value="${user.id}"/>" aria-hidden="true">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="userLabel<c:out value="${user.id}"/>">Chi tiết khách hàng</h5>
                                                                    <button type="button" class="close" data-dismiss="modal"
                                                                            aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <form action="${request.contextPath}/updateUser" method="post">
                                                                        <div class="card-body">
                                                                            <input type="hidden" name="uid" value="${user.id}">
                                                                            <div class="form-group">
                                                                                <label for="emailInfo">Email address</label>
                                                                                <input type="email" class="form-control"
                                                                                       id="emailInfo" placeholder="Enter email" value="<c:out value="${user.email}"/>"
                                                                                name="email">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label for="nameInfo">Name</label>
                                                                                <input type="text" class="form-control"
                                                                                       id="nameInfo" placeholder="Khánh loằn" value="<c:out value="${user.name}"/>"
                                                                                name="name">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label for="phone">phone</label>
                                                                                <input type="text" class="form-control"
                                                                                       id="phoneInfo" placeholder="09232142321" value="<c:out value="${user.phone}"/>"
                                                                                name="phone">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label for="addressInfo">Address</label>
                                                                                <input type="text" class="form-control"
                                                                                       id="addressInfo" placeholder="TP.HCM" value="<c:out value="${user.address}"/>"
                                                                                name="address">
                                                                            </div>

                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button" class="btn btn-secondary"
                                                                                    data-dismiss="modal">Đóng
                                                                            </button>
                                                                            <div class=Submit>
                                                                                <button type="submit" class="btn btn-danger">Lưu</button>
                                                                            </div>

                                                                        </div>
                                                                    </form>
                                                                </div>

                                                            </div>
                                                        </div>
                                                    </div>
                                                    <a class="fas fa-trash-alt" style="cursor: pointer"
                                                       href="${request.contextPath}/removeUser?uid=${user.id}"></a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Email</th>
                                        <th>Phone</th>
                                        <th>Address</th>
                                        <th>Role</th>
                                        <th>Action</th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>


    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong>
        All rights reserved.
        <div class="float-right d-none d-sm-inline-block">
            <b>Version</b> 3.2.0-rc
        </div>
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>


<!-- jQuery -->
<script src="<c:url value="/admin/plugins/jquery/jquery.min.js"/>"></script>

<!-- jQuery UI 1.11.4 -->
<script src="<c:url value="/admin/plugins/jquery-ui/jquery-ui.min.js"/>"></script>

<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button)
</script>

<!-- Bootstrap 4 -->
<script src="<c:url value="/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<script src="<c:url value="/admin/dist/js/adminlte.js"/>"></script>

<script src="<c:url value="/admin/dist/js/pages/dashboard.js"/>"></script>

<!-- DataTables  & Plugins -->
<%--<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>--%>
<script src="<c:url value="/admin/plugins/datatables/jquery.dataTables.min.js"/>"></script>
<%--<script src="../../plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>--%>
<script src="<c:url value="/admin/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"/>"></script>
<%--<script src="../../plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>--%>
<script src="<c:url value="/admin/plugins/datatables-responsive/js/dataTables.responsive.min.js"/>"></script>
<%--<script src="../../plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>--%>
<script src="<c:url value="/admin/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"/>"></script>
<%--<script src="../../plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>--%>
<script src="<c:url value="/admin/plugins/datatables-buttons/js/dataTables.buttons.min.js"/>"></script>
<%--<script src="../../plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>--%>
<script src="<c:url value="/admin/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"/>"></script>
<%--<script src="../../plugins/jszip/jszip.min.js"></script>--%>
<%--<script src="<c:url value="/admin/plugins/jszip/jszip.min.js"/>"></script>--%>
<%--<script src="../../plugins/pdfmake/pdfmake.min.js"></script>--%>
<%--<script src="<c:url value="/admin/plugins/pdfmake/pdfmake.min.js"/>"></script>--%>
<%--<script src="../../plugins/pdfmake/vfs_fonts.js"></script>--%>
<%--<script src="<c:url value="/admin/plugins/pdfmake/vfs_fonts.js"/>"></script>--%>
<%--<script src="../../plugins/datatables-buttons/js/buttons.html5.min.js"></script>--%>
<script src="<c:url value="/admin/plugins/datatables-buttons/js/buttons.html5.min.js"/>"></script>
<%--<script src="../../plugins/datatables-buttons/js/buttons.print.min.js"></script>--%>
<script src="<c:url value="/admin/plugins/datatables-buttons/js/buttons.print.min.js"/>"></script>
<%--<script src="../../plugins/datatables-buttons/js/buttons.colVis.min.js"></script>--%>
<script src="<c:url value="/admin/plugins/datatables-buttons/js/buttons.colVis.min.js"/>"></script>
<script>
    $(function () {
        $("#example1").DataTable({
            "responsive": true, "lengthChange": false, "autoWidth": false,
            "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
        }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false,
            "responsive": true,
        });
    });
</script>
</body>
</html>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="index.html">SB Admin</a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		
		<%@ include file="/common/admin/menu.jsp" %>

		<ul class="nav navbar-nav navbar-right navbar-user">
			<li class="dropdown messages-dropdown"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown"><i
					class="fa fa-envelope"></i> Messages <span class="badge">7</span> <b
					class="caret"></b></a></li>
			<li class="dropdown alerts-dropdown"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown"><i
					class="fa fa-bell"></i> Alerts <span class="badge">3</span> <b
					class="caret"></b></a></li>
			<li class="dropdown user-dropdown"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown"><i
					class="fa fa-user"></i> John Smith <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
					<li><a href="#"><i class="fa fa-envelope"></i> Inbox <span
							class="badge">7</span></a></li>
					<li><a href="#"><i class="fa fa-gear"></i> Settings</a></li>
					<li class="divider"></li>
					<li><a href="#"><i class="fa fa-power-off"></i> Log Out</a></li>
				</ul></li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</nav>
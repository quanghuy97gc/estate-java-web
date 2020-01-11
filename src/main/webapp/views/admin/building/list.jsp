<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="redirectEdit" value="/admin-building?action=EDIT" />
<!DOCTYPE html>
<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {
				}
			</script>

			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
				</li>

				<li><a href="#">Other Pages</a></li>
				<li class="active">Blank Page</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>

		<div class="page-content">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row">
				<div class="col-xs-12">
					<div class="widget-box">
						<div class="widget-header">
							<h4 class="widget-title">Tìm Kiếm</h4>

							<div class="widget-toolbar">
								<a href="#" data-action="collapse"> <i
									class="ace-icon fa fa-chevron-up"></i>
								</a>
							</div>
						</div>
						<div class="widget-body">
							<div class="widget-main">
								<form class="form-horizontal" role="form">
									<div class="form-group">
										<div class="col-sm-6">
											<div>
												<label for="name">Tên sản phẩm</label>
												<input type="text" id="name" class="form-control"
													name="name" />
											</div>
										</div>
										<div class="col-sm-6">
											<div>
												<label for="buildingArea">Diện tích sàn</label>
												<input type="number" id="buildingArea" class="form-control"
													name="buildingArea" />
											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="col-sm-4">
											<div>
												<label for="district">Quận</label>
												<input type="text" id="district" class="form-control"
													name="district" />
											</div>
										</div>
										<div class="col-sm-4">
											<div>
												<label for="ward">Phường</label>
												<input type="text" id="ward" class="form-control"
													name="ward" />
											</div>
										</div>
										<div class="col-sm-4">
											<div>
												<label for="street">Đường</label>
												<input type="text" id="street" class="form-control"
													name="street" />
											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="col-sm-4">
											<div>
												<label for="numberOfBasement">Số tầng hầm</label>
												<input type="text" id="numberOfBasement"
													class="form-control" name="numberOfBasement" />
											</div>
										</div>
										<div class="col-sm-4">
											<div>
												<label for="direction">Hướng</label>
												<input type="text" id="direction" class="form-control"
													name="direction" disabled />
											</div>
										</div>
										<div class="col-sm-4">
											<div>
												<label for="level">Hạng</label>
												<input type="number" id="level" class="form-control"
													name="level" disabled />
											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="col-sm-3">
											<div>
												<label for="areaRentFrom">Diện tích từ</label>
												<input type="number" id="areaRentFrom" class="form-control"
													name="areaRentFrom" />
											</div>
										</div>
										<div class="col-sm-3">
											<div>
												<label for="areaRentTo">Diện tích đến</label>
												<input type="number" id="areaRentTo" class="form-control"
													name="areaRentTo" />
											</div>
										</div>
										<div class="col-sm-3">
											<div>
												<label for="costRentFrom">Giá thuê từ</label>
												<input type="number" id="costRentFrom" class="form-control"
													name="costRentFrom" />
											</div>
										</div>
										<div class="col-sm-3">
											<div>
												<label for="costRentTo">Giá thuê đến</label>
												<input type="number" id="costRentTo" class="form-control"
													name="costRentTo" />
											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="col-sm-4">
											<div>
												<label for="managerName">Tên quản lý</label>
												<input type="text" id="managerName" class="form-control"
													name="managerName" />
											</div>
										</div>
										<div class="col-sm-4">
											<div>
												<label for="managerPhone">Điện thoại quản lý</label>
												<input type="text" id="managerPhone" class="form-control"
													name="managerPhone" />
											</div>
										</div>
										<div class="col-sm-3">
											<div>
												<label for="userId">Chọn nhân viên phụ trách</label>
												<select class="selectpicker form-control" id="selStaff">
													<option id="title" selected hidden="true">--chọn
														nhân viên phụ trách--</option>
													<option id="2" value="2">Nguyễn Văn A</option>
													<option id="3" value="3">Nguyễn Văn B</option>
													<option id="4" value="4">Nguyễn Văn C</option>
												</select>
											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="col-sm-4">
											<label class="checkbox-inline">
												<input type="checkbox" value="TANG_TRET" id="TANG_TRET" name="buildingTypes">
												Tầng trệt
											</label>
											<label class="checkbox-inline">
												<input type="checkbox" value="NGUYEN_CAN" id="NGUYEN_CAN" name="buildingTypes">
												Nguyên căn
											</label>
											<label class="checkbox-inline">
												<input type="checkbox" value="NOI_THAT" id="NOI_THAT" name="buildingTypes">
												Nội thất
											</label>
										</div>
									</div>
									
									<div class="form-group">
										<div class="col-sm-4">
											<button id="btnSearch" type="button"
												class="btn btn-sm btn-success">
												Tìm Kiếm
												<span class="ace-icon fa fa-search icon-on-right bigger-110 fa-flip-horizontal"></span>
											</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-12">
					<div class="pull-right">
						<a href="${redirectEdit}" class="btn btn-white btn-info btn-bold" id="addBuilding"
							data-toggle="tooltip" title="Thêm sản phẩm"> <i
							class="fa fa-plus-circle bigger-120 blue"></i>
						</a>

						<button class="btn btn-white btn-warning btn-bold"
							id="deleteBuilding" data-toggle="tooltip" title="Xóa sản phẩm">
							<i class="fa fa-trash-o bigger-120 orange"></i>
						</button>
					</div>
				</div>
			</div>

			<br />

			<div class="row">
				<div class="col-xs-12">
					<table id="buildingList"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th class="center"><input type="checkbox" value=""
										id="checkbox" /></th>
								<th>Tên sản phẩm</th>
								<th>Địa chỉ</th>
								<th>Tên quản lý</th>
								<th>Số điện thoại</th>
								<th>D.T sàn</th>
								<th>Giá thuê</th>
								<th>Phí dịch vụ</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="center"><input type="checkbox" value="1"
										id="checkbox_1" /></td>
								<td>FCL Building</td>
								<td>59 Phan Xích Long</td>
								<td>a Huy</td>
								<td>0961564057</td>
								<td>200</td>
								<td>500$</td>
								<td>20$</td>
								<td>
									<div class="hidden-sm hidden-xs btn-group">
										<button class="btn btn-xs btn-info" data-toggle="tooltip"
											title="Giao tòa nhà" onclick="assignBuilding(1)">
											<i class="ace-icon fa fa-bars bigger-120"></i>
										</button>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div>
		<!-- /.page-content -->
	</div>
</div>
<!-- /.main-content -->

<!-- Modal -->
<div class="modal fade" id="assignBuildingModal" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Danh sách nhân viên giao Sản Phẩm</h4>
			</div>
			<div class="modal-body">
				<table id="staffList"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="center">Chọn nhân viên</th>
							<th class="center">Tên nhân viên</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="center"><input type="checkbox" value="2"
									id="checkbox_1" /></td>
							<td class="center">Nguyễn Văn A</td>
						</tr>
						<tr>
							<td class="center"><input type="checkbox" value="3"
									id="checkbox_2" /></td>
							<td class="center">Nguyễn Văn B</td>
						</tr>
					</tbody>
				</table>
				<input type="hidden" id="buildingId" class="form-control"
					name="buildingId" value="" />
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" id="btnAssignBuilding">Giao
					tòa nhà</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>


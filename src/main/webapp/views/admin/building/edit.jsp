<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
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
					<form class="form-horizontal" role="form" id="formEdit">
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="name">Tên
								sản phẩm</label>
							<div class="col-sm-9">
								<input type="text" id="name" class="form-control" name="name" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="district">Quận</label>
							<div class="col-sm-9">
								<input type="text" id="district" class="form-control"
									name="district" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="ward">Phường</label>
							<div class="col-sm-9">
								<input type="text" id="ward" class="form-control" name="ward" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="street">Đường</label>
							<div class="col-sm-9">
								<input type="text" id="street" class="form-control"
									name="street" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="structure">Kết cấu</label>
							<div class="col-sm-9">
								<input type="text" id="structure" class="form-control"
									name="structure" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="numberOfBasement">Số tầng hầm</label>
							<div class="col-sm-9">
								<input type="number" id="numberOfBasement" class="form-control"
									name="numberOfBasement" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="buildingArea">Diện tích sàn</label>
							<div class="col-sm-9">
								<input type="number" id="buildingArea" class="form-control"
									name="buildingArea" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="rentArea">Diện tích thuê</label>
							<div class="col-sm-9">
								<input type="text" id="rentArea" class="form-control"
									name="rentArea" />
							</div>
						</div>
						<!--div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="name">Mô tả diện tích</label>
										<div class="col-sm-9">
											<input type="text" id="name" class="form-control" name="name"/>
										</div>
									</div-->
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="costRent">Giá thuê</label>
							<div class="col-sm-9">
								<input type="number" id="costRent" class="form-control"
									name="costRent" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="costDescription">Mô tả giá</label>
							<div class="col-sm-9">
								<input type="text" id="costDescription" class="form-control"
									name="costDescription" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="serviceCost">Phí dịch vụ</label>
							<div class="col-sm-9">
								<input type="text" id="serviceCost" class="form-control"
									name="serviceCost" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="carCost">Phí ô tô</label>
							<div class="col-sm-9">
								<input type="text" id="carCost" class="form-control"
									name="carCost" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="motorbikeCost">Phí mô tô</label>
							<div class="col-sm-9">
								<input type="text" id="motorbikeCost" class="form-control"
									name="motorbikeCost" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="overtimeCost">Phí ngoài giờ</label>
							<div class="col-sm-9">
								<input type="text" id="overtimeCost" class="form-control"
									name="overtimeCost" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="electricityCost">Tiền điện</label>
							<div class="col-sm-9">
								<input type="text" id="electricityCost" class="form-control"
									name="electricityCost" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="deposit">Đặt cọc</label>
							<div class="col-sm-9">
								<input type="text" id="deposit" class="form-control"
									name="deposit" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="payment">Thanh toán</label>
							<div class="col-sm-9">
								<input type="text" id="payment" class="form-control"
									name="payment" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="timeRent">Thời hạn thuê</label>
							<div class="col-sm-9">
								<input type="text" id="timeRent" class="form-control"
									name="timeRent" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="timeDecorator">Thời gian trang trí</label>
							<div class="col-sm-9">
								<input type="text" id="timeDecorator" class="form-control"
									name="timeDecorator" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="managerName">Tên quản lý</label>
							<div class="col-sm-9">
								<input type="text" id="managerName" class="form-control"
									name="managerName" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right"
								for="managerPhone">SĐT quản lý</label>
							<div class="col-sm-9">
								<input type="text" id="managerPhone" class="form-control"
									name="managerPhone" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="name">Loại
								sản phẩm</label>
							<div class="col-sm-9" id="buildingTypes">
								<label class="checkbox-inline">
									<input type="checkbox" value="TANG_TRET" id="TANG_TRET"
										name="buildingTypes">
									Tầng trệt
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" value="NGUYEN_CAN" id="NGUYEN_CAN"
										name="buildingTypes">
									Nguyên căn
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" value="NOI_THAT" id="NOI_THAT"
										name="buildingTypes">
									Nội thất
								</label>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="name"></label>
							<div class="col-sm-9">
								<button id="btnAddBuilding" type="button"
									class="btn btn-sm btn-success">Thêm tòa nhà</button>
								<button id="btnCancel" type="button"
									class="btn btn-sm btn-warning">Hủy</button>
							</div>
						</div>
					</form>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
			<!-- PAGE CONTENT ENDS -->
		</div>
		<!-- /.page-content -->
	</div>
</div>
<!-- /.main-content -->
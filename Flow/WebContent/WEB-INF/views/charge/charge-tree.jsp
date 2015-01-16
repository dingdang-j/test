<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<html>
<head>
<title>收费规则树</title>
<script type="text/javascript"
	src="${ctx }/static-content?contentPath=/charge/charge-tree.js"></script>
</head>

<body>
	<form id="frm" action="${ctx }/charge!create.action" method="post">

		<!-- 定价计划 -->
		<div class="row">
			<div>
				<button id="shrinkBtn" type="button" class="btn btn-warning btn-xs">
					&nbsp;<span class="glyphicon glyphicon-minus"></span>&nbsp;
				</button>
				<button id="expandBtn" type="button" class="btn btn-warning btn-xs">
					&nbsp;<span class="glyphicon glyphicon-plus"></span>&nbsp;
				</button>
				<input type="submit" value="创建" class="btn btn-success btn-xs" />
			</div>

			<div class="col-md-6 col-md-offset-3 form-horizontal">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">定价计划</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<label class="col-sm-4 control-label">id</label>
							<div class="col-sm-6">
								<input type="text" class="form-control input-sm" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">合同编号</label>
							<div class="col-sm-6">
								<input type="text" name="pricingPlanInfo.contractCode"
									class="form-control input-sm" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">名称</label>
							<div class="col-sm-6">
								<input type="text" name="pricingPlanInfo.pricingPlanName"
									class="form-control input-sm" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">资费说明</label>
							<div class="col-sm-6">
								<input type="text" name="pricingPlanInfo.pricingDesc"
									class="form-control input-sm" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 		<div class="row"> -->
		<!-- 			<!-- 定价组合 -->
		<!-- 			<div class="col-md-4 col-md-offset-2 form-horizontal"> -->
		<!-- 				<div class="panel panel-info"> -->
		<!-- 					<div class="panel-heading"> -->
		<!-- 						<h3 class="panel-title">定价组合</h3> -->
		<!-- 					</div> -->
		<!-- 					<div class="panel-body"> -->
		<!-- 						<div class="form-group"> -->
		<!-- 							<label class="col-sm-6 control-label">id</label> -->
		<!-- 							<div class="col-sm-5"> -->
		<!-- 								<input type="text" class="form-control input-sm" /> -->
		<!-- 							</div> -->
		<!-- 						</div> -->
		<!-- 												<div class="form-group"> -->
		<!-- 													<label class="col-sm-6 control-label">定价计划id</label> -->
		<!-- 													<div class="col-sm-5"> -->
		<!-- 														<input type="text" class="form-control input-sm" /> -->
		<!-- 													</div> -->
		<!-- 												</div> -->
		<!-- 												<div class="form-group"> -->
		<!-- 													<label class="col-sm-6 control-label">事件定价策略id</label> -->
		<!-- 													<div class="col-sm-5"> -->
		<!-- 														<input type="text" class="form-control input-sm" /> -->
		<!-- 													</div> -->
		<!-- 												</div> -->
		<!-- 												<div class="form-group"> -->
		<!-- 													<label class="col-sm-6 control-label">生命周期id</label> -->
		<!-- 													<div class="col-sm-5"> -->
		<!-- 														<input type="text" class="form-control input-sm" /> -->
		<!-- 													</div> -->
		<!-- 												</div> -->
		<!-- 						<div class="form-group"> -->
		<!-- 							<label class="col-sm-6 control-label">计算优先级</label> -->
		<!-- 							<div class="col-sm-5"> -->
		<!-- 								<input type="text" -->
		<!-- 									name="pricingPlanInfo.combines[0].calcPriority" -->
		<!-- 									class="form-control input-sm" /> -->
		<!-- 							</div> -->
		<!-- 						</div> -->
		<!-- 					</div> -->
		<!-- 				</div> -->
		<!-- 			</div> -->
		<!-- 		</div> -->

		<!-- 事件定价策略 -->
		<div class="row">
			<!-- 生命周期 -->
			<div class="col-md-4 col-md-offset-0 form-horizontal">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">生命周期</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<label class="col-sm-6 control-label">id</label>
							<div class="col-sm-5">
								<input type="text" class="form-control input-sm" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label">状态</label>
							<div class="col-sm-5">
								<s:select
									list="@com.yiji.core.charge.modules.enums.StateEnum@values()"
									name="pricingPlanInfo.combines[0].lifeCycle.state"
									cssClass="form-control input-sm" listKey="name()"
									listValue="message" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label">日期生效方式</label>
							<div class="col-sm-5">
								<s:select
									list="@com.yiji.core.charge.modules.enums.EffTypeEnum@values()"
									name="pricingPlanInfo.combines[0].lifeCycle.effType"
									cssClass="form-control input-sm" listKey="name()"
									listValue="message" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label">生效日期</label>
							<div class="col-sm-5">
								<input type="text"
									name="pricingPlanInfo.combines[0].lifeCycle.effDate"
									class="form-control input-sm" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label">失效日期</label>
							<div class="col-sm-5">
								<input type="text"
									name="pricingPlanInfo.combines[0].lifeCycle.expDate"
									class="form-control input-sm" />
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-5 col-md-offset-0 form-horizontal">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">事件定价策略</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<label class="col-sm-6 control-label">id</label>
							<div class="col-sm-5">
								<input type="text" class="form-control input-sm" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label">计费事件id</label>
							<div class="col-sm-5">
								<input type="text"
									name="pricingPlanInfo.combines[0].strategy.eventId"
									class="form-control input-sm" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label">合同编号</label>
							<div class="col-sm-5">
								<input type="text"
									name="pricingPlanInfo.combines[0].strategy.contractCode"
									class="form-control input-sm" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label">名称</label>
							<div class="col-sm-5">
								<input type="text"
									name="pricingPlanInfo.combines[0].strategy.eventPricingStrategyName"
									class="form-control input-sm" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label">描述</label>
							<div class="col-sm-5">
								<input type="text"
									name="pricingPlanInfo.combines[0].strategy.eventPricingStrategyDesc"
									class="form-control input-sm" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-6 control-label">计算优先级</label>
							<div class="col-sm-5">
								<input type="text"
									name="pricingPlanInfo.combines[0].calcPriority"
									class="form-control input-sm" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 定价段落1. -->
		<div class="col-md-6">
			<div class="row">
				<div class="col-md-4">
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">参考对象</h3>
							</div>
							<div class="panel-body">
								<div class="form-group">
									<label>属主属性类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.MeasureMethodEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].pricingRefObject.propertyDefineType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>积量类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.RatableResourceEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].pricingRefObject.ratableResource"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>属主类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.ObjectTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].pricingRefObject.ownerType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>外部属性名称</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].pricingRefObject.externPropertyString"
										class="form-control input-sm" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">段落起始取值</h3>
							</div>
							<div class="panel-body">
								<div class="form-group">
									<label>参数值类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.RefValueTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].startRefValue.refValueType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>数值类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.AttrValueTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].startRefValue.valueType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>对应数值</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].startRefValue.valueString"
										class="form-control input-sm" />
								</div>
								<div class="form-group">
									<label>对应参数对象（暂不使用）</label>
									<!-- 								<input type="text" -->
									<!-- 									name="pricingPlanInfo.combines[0].strategy.sections[0].startRefValue.valueType" -->
									<!-- 									class="form-control input-sm" /> -->
								</div>
								<div class="form-group">
									<label>费率精度</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].startRefValue.ratePrecision"
										class="form-control input-sm" />
								</div>
								<div class="form-group">
									<label>计算精度</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].startRefValue.calcPrecision"
										class="form-control input-sm" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">段落终止取值</h3>
							</div>
							<div class="panel-body">
								<div class="form-group">
									<label>参数值类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.RefValueTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].endRefValue.refValueType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>数值类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.AttrValueTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].endRefValue.valueType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>对应数值</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].endRefValue.valueString"
										class="form-control input-sm" />
								</div>
								<div class="form-group">
									<label>对应参数对象（暂不使用）</label>
								</div>
								<div class="form-group">
									<label>费率精度</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].endRefValue.ratePrecision"
										class="form-control input-sm" />
								</div>
								<div class="form-group">
									<label>计算精度</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].endRefValue.calcPrecision"
										class="form-control input-sm" />
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-8 col-md-offset-0 form-horizontal">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">定价段落 - 1</h3>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label class="col-sm-6 control-label">id</label>
								<div class="col-sm-6">
									<input type="text" class="form-control input-sm" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">段落类型</label>
								<div class="col-sm-6">
									<s:select
										list="@com.yiji.core.charge.modules.enums.SectionTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].sectionType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">分段计算类型</label>
								<div class="col-sm-6">
									<s:select
										list="@com.yiji.core.charge.modules.enums.SectionCalcTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].sectionCalcType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">名称</label>
								<div class="col-sm-6">
									<input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].pricingSectionName"
										class="form-control input-sm" />
								</div>
							</div>
							<!-- 						<div class="form-group"> -->
							<!-- 							<label class="col-sm-6 control-label">事件定价策略id</label> -->
							<!-- 							<div class="col-sm-6"> -->
							<!-- 								<input type="text" class="form-control input-sm" /> -->
							<!-- 							</div> -->
							<!-- 						</div> -->
							<!-- 						<div class="form-group"> -->
							<!-- 							<label class="col-sm-6 control-label">父定价段落id</label> -->
							<!-- 							<div class="col-sm-6"> -->
							<!-- 								<input type="text" class="form-control input-sm" /> -->
							<!-- 							</div> -->
							<!-- 						</div> -->
							<!-- 						<div class="form-group"> -->
							<!-- 							<label class="col-sm-6 control-label">参考对象id</label> -->
							<!-- 							<div class="col-sm-6"> -->
							<!-- 								<input type="text" class="form-control input-sm" /> -->
							<!-- 							</div> -->
							<!-- 						</div> -->
							<!-- 						<div class="form-group"> -->
							<!-- 							<label class="col-sm-6 control-label">段落起始取值id</label> -->
							<!-- 							<div class="col-sm-6"> -->
							<!-- 								<input type="text" class="form-control input-sm" /> -->
							<!-- 							</div> -->
							<!-- 						</div> -->
							<!-- 						<div class="form-group"> -->
							<!-- 							<label class="col-sm-6 control-label">段落终止取值id</label> -->
							<!-- 							<div class="col-sm-6"> -->
							<!-- 								<input type="text" class="form-control input-sm" /> -->
							<!-- 							</div> -->
							<!-- 						</div> -->
							<div class="form-group">
								<label class="col-sm-6 control-label">计算优先级</label>
								<div class="col-sm-6">
									<input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].calcPriority"
										class="form-control input-sm" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- 资费标准 -->
			<div class="row">
				<div class="col-md-4">
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">固定费率</h3>
							</div>
							<div class="panel-body">
								<div class="form-group">
									<label>参数值类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.RefValueTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].fixedRateValue.refValueType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>数值类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.AttrValueTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].fixedRateValue.valueType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>对应数值</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].fixedRateValue.valueString"
										class="form-control input-sm" />
								</div>
								<div class="form-group">
									<label>费率精度</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].fixedRateValue.ratePrecision"
										class="form-control input-sm" />
								</div>
								<div class="form-group">
									<label>计算精度</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].fixedRateValue.calcPrecision"
										class="form-control input-sm" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">单位费率</h3>
							</div>
							<div class="panel-body">
								<div class="form-group">
									<label>参数值类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.RefValueTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].scaledRateValue.refValueType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>数值类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.AttrValueTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].scaledRateValue.valueType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>对应数值</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].scaledRateValue.valueString"
										class="form-control input-sm" />
								</div>
								<div class="form-group">
									<label>费率精度</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].scaledRateValue.ratePrecision"
										class="form-control input-sm" />
								</div>
								<div class="form-group">
									<label>计算精度</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].scaledRateValue.calcPrecision"
										class="form-control input-sm" />
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-8 col-md-offset-0 form-horizontal">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">段落 - 1_资费标准</h3>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label class="col-sm-6 control-label">id</label>
								<div class="col-sm-6">
									<input type="text" class="form-control input-sm" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">资费标准类型</label>
								<div class="col-sm-6">
									<s:select
										list="@com.yiji.core.charge.modules.enums.TariffTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].tariffType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">计算方法</label>
								<div class="col-sm-6">
									<s:select
										list="@com.yiji.core.charge.modules.enums.TariffCalcEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].calcMethod"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">积量类型</label>
								<div class="col-sm-6">
									<s:select
										list="@com.yiji.core.charge.modules.enums.RatableResourceEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].ratableResource"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">计费单元数</label>
								<div class="col-sm-6">
									<input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].rateUnit"
										class="form-control input-sm" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">资费单位</label>
								<div class="col-sm-6">
									<s:select
										list="@com.yiji.core.charge.modules.enums.TariffUnitEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].tariffUnit"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">付费方标志</label>
								<div class="col-sm-6">
									<s:select
										list="@com.yiji.core.charge.modules.enums.ChargePartyFlagEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].chargeParty"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">账户配置id</label>
								<div class="col-sm-6">
									<input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].acctConfigId"
										class="form-control input-sm" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">计算优先级</label>
								<div class="col-sm-6">
									<input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].calcPriority"
										class="form-control input-sm" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>


		</div>
		<!-- 定价段落1. -->
		<div class="col-md-6">
			<div class="row">
				<div class="col-md-4">
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">参考对象</h3>
							</div>
							<div class="panel-body">
								<div class="form-group">
									<label>属主属性类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.MeasureMethodEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].pricingRefObject.propertyDefineType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>积量类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.RatableResourceEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].pricingRefObject.ratableResource"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>属主类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.ObjectTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].pricingRefObject.ownerType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>外部属性名称</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].pricingRefObject.externPropertyString"
										class="form-control input-sm" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">段落起始取值</h3>
							</div>
							<div class="panel-body">
								<div class="form-group">
									<label>参数值类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.RefValueTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].startRefValue.refValueType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>数值类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.AttrValueTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].startRefValue.valueType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>对应数值</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].startRefValue.valueString"
										class="form-control input-sm" />
								</div>
								<div class="form-group">
									<label>对应参数对象（暂不使用）</label>
									<!-- 								<input type="text" -->
									<!-- 									name="pricingPlanInfo.combines[0].strategy.sections[0].startRefValue.valueType" -->
									<!-- 									class="form-control input-sm" /> -->
								</div>
								<div class="form-group">
									<label>费率精度</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].startRefValue.ratePrecision"
										class="form-control input-sm" />
								</div>
								<div class="form-group">
									<label>计算精度</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].startRefValue.calcPrecision"
										class="form-control input-sm" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">段落终止取值</h3>
							</div>
							<div class="panel-body">
								<div class="form-group">
									<label>参数值类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.RefValueTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].endRefValue.refValueType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>数值类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.AttrValueTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].endRefValue.valueType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>对应数值</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].endRefValue.valueString"
										class="form-control input-sm" />
								</div>
								<div class="form-group">
									<label>对应参数对象（暂不使用）</label>
								</div>
								<div class="form-group">
									<label>费率精度</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].endRefValue.ratePrecision"
										class="form-control input-sm" />
								</div>
								<div class="form-group">
									<label>计算精度</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].endRefValue.calcPrecision"
										class="form-control input-sm" />
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-8 col-md-offset-0 form-horizontal">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">定价段落 - 2</h3>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label class="col-sm-6 control-label">id</label>
								<div class="col-sm-6">
									<input type="text" class="form-control input-sm" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">段落类型</label>
								<div class="col-sm-6">
									<s:select
										list="@com.yiji.core.charge.modules.enums.SectionTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].sectionType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">分段计算类型</label>
								<div class="col-sm-6">
									<s:select
										list="@com.yiji.core.charge.modules.enums.SectionCalcTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].sectionCalcType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">名称</label>
								<div class="col-sm-6">
									<input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].pricingSectionName"
										class="form-control input-sm" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">计算优先级</label>
								<div class="col-sm-6">
									<input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].calcPriority"
										class="form-control input-sm" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- 资费标准 -->
			<div class="row">
				<div class="col-md-4">
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">固定费率</h3>
							</div>
							<div class="panel-body">
								<div class="form-group">
									<label>参数值类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.RefValueTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].fixedRateValue.refValueType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>数值类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.AttrValueTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].fixedRateValue.valueType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>对应数值</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].fixedRateValue.valueString"
										class="form-control input-sm" />
								</div>
								<div class="form-group">
									<label>费率精度</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].fixedRateValue.ratePrecision"
										class="form-control input-sm" />
								</div>
								<div class="form-group">
									<label>计算精度</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].fixedRateValue.calcPrecision"
										class="form-control input-sm" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading">
								<h3 class="panel-title">单位费率</h3>
							</div>
							<div class="panel-body">
								<div class="form-group">
									<label>参数值类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.RefValueTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].scaledRateValue.refValueType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>数值类型</label>
									<s:select
										list="@com.yiji.core.charge.modules.enums.AttrValueTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].scaledRateValue.valueType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
								<div class="form-group">
									<label>对应数值</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].scaledRateValue.valueString"
										class="form-control input-sm" />
								</div>
								<div class="form-group">
									<label>费率精度</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].scaledRateValue.ratePrecision"
										class="form-control input-sm" />
								</div>
								<div class="form-group">
									<label>计算精度</label> <input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].scaledRateValue.calcPrecision"
										class="form-control input-sm" />
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-8 col-md-offset-0 form-horizontal">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">段落 - 2_资费标准</h3>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label class="col-sm-6 control-label">id</label>
								<div class="col-sm-6">
									<input type="text" class="form-control input-sm" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">资费标准类型</label>
								<div class="col-sm-6">
									<s:select
										list="@com.yiji.core.charge.modules.enums.TariffTypeEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].tariffType"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">计算方法</label>
								<div class="col-sm-6">
									<s:select
										list="@com.yiji.core.charge.modules.enums.TariffCalcEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].calcMethod"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">积量类型</label>
								<div class="col-sm-6">
									<s:select
										list="@com.yiji.core.charge.modules.enums.RatableResourceEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].ratableResource"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">计费单元数</label>
								<div class="col-sm-6">
									<input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].rateUnit"
										class="form-control input-sm" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">资费单位</label>
								<div class="col-sm-6">
									<s:select
										list="@com.yiji.core.charge.modules.enums.TariffUnitEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].tariffUnit"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">付费方标志</label>
								<div class="col-sm-6">
									<s:select
										list="@com.yiji.core.charge.modules.enums.ChargePartyFlagEnum@values()"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].chargeParty"
										cssClass="form-control input-sm" listKey="name()"
										listValue="message" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">账户配置id</label>
								<div class="col-sm-6">
									<input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].acctConfigId"
										class="form-control input-sm" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-6 control-label">计算优先级</label>
								<div class="col-sm-6">
									<input type="text"
										name="pricingPlanInfo.combines[0].strategy.sections[0].tariffs[0].calcPriority"
										class="form-control input-sm" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</form>
</body>
</html>
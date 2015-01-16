package com.ylink.flow.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.opensymphony.xwork2.ActionSupport;
import com.ylink.flow.bean.FlowBean;
import com.ylink.flow.bean.FlowConnectionBean;
import com.ylink.utils.web.struts2.Struts2Utils;

/**
 * Flow控制层.
 * 
 * @author 潘瑞峥
 * @date 2012-10-9
 */
public class FlowAction extends ActionSupport {

	private static final long serialVersionUID = 2010933014227420599L;

	private Logger logger = LoggerFactory.getLogger( this.getClass() );

	/**
	 * json.
	 * 
	 * @return
	 */
	public String json() {
		logger.debug( "json..." );

		Map<String, Object> json = Maps.newHashMap();

		/* 初始化节点数据 */
		List<FlowBean> flowBeans = Lists.newArrayList();
		FlowBean flowBean = null;

		int count = 7;
		for ( int i = 1; i <= count; i++ ) {
			flowBean = new FlowBean();
			flowBean.setId( i + "" );
			flowBean.setName( "node_" + i );
			// 0.等待 1.通过 2.暂停
			flowBean.setState( "1" );
			flowBean.setRemark( "tip_" + i );
			if ( count != i ) {
				flowBean.getNextNodes().add( i + 1 + "" );
			}
			flowBeans.add( flowBean );
		}

		flowBeans.get( 5 ).setState( "2" );
		flowBeans.get( 6 ).setState( "0" );

		json.put( "flows", flowBeans );
		json.put( "flowConnections", this.buildConnections( flowBeans ) );

		Struts2Utils.renderJson( json );
		return null;
	}

	/**
	 * buildJson.
	 * 
	 * @return
	 */
	public String buildJson() {
		logger.debug( "buildJson..." );

		Map<String, Object> json = Maps.newHashMap();

		/* 初始化节点数据 */
		List<FlowBean> flowBeans = Lists.newArrayList();
		FlowBean flowBean = null;

		flowBean = new FlowBean( "1", "异动申请(潘XX)", "异动申请(潘XX)", "1" );
		flowBean.getNextNodes().add( "2" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "2", "现职部门(程XX)", "现职部门(程XX)", "1" );
		flowBean.getNextNodes().add( "3" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "3", "现职部门(陈XX)", "现职部门(陈XX)", "1" );
		flowBean.getNextNodes().add( "4" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "4", "入职部门(管XX)", "入职部门(管XX)", "1" );
		flowBean.getNextNodes().add( "5" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "5", "现职部门(赵总)", "现职部门(赵总)", "1" );
		flowBean.getNextNodes().add( "6" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "6", "现职部门(张总)", "现职部门(张总)", "2" );
		flowBean.getNextNodes().add( "7" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "7", "总经理审批(席总)", "总经理审批(席总)", "0" );
		flowBean.getNextNodes().add( "8" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "8", "行政核实(邹X)", "行政核实(邹X)", "0" );
		flowBean.getNextNodes().add( "9" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "9", "员工关系专员(叶XX)", "员工关系专员(叶XX)", "0" );
		flowBean.getNextNodes().add( "10" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "10", "知会申请人(潘XX)", "知会申请人(潘XX)", "0" );
		flowBean.getNextNodes().add( "11" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "11", "归档(程XX)", "归档(程XX)", "0" );
		flowBeans.add( flowBean );

		json.put( "flows", flowBeans );
		json.put( "flowConnections", this.buildConnections( flowBeans ) );

		Struts2Utils.renderJson( json );
		return null;
	}

	/**
	 * manualJson.
	 * 
	 * @return
	 */
	public String manualJson() {
		logger.debug( "manualJson..." );

		Map<String, Object> json = Maps.newHashMap();

		/* 初始化节点数据 */
		List<FlowBean> flowBeans = Lists.newArrayList();
		FlowBean flowBean = null;

		flowBean = new FlowBean( "1", "提交申请", "提交申请", "2" );
		flowBean.getNextNodes().add( "2" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "2", "稽核会计", "稽核会计", "1" );
		flowBean.getNextNodes().add( "3" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "3", "预算会计", "预算会计", "0" );
		flowBean.getNextNodes().add( "4" );
		flowBean.getNextNodes().add( "7" );
		flowBean.getNextNodes().add( "8" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "4", "项目经理", "项目经理", "0" );
		flowBean.getNextNodes().add( "5" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "5", "部门经理审核", "部门经理审核", "0" );
		flowBean.getNextNodes().add( "6" );
		flowBean.getNextNodes().add( "9" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "6", "一级部门经理", "一级部门经理", "0" );
		flowBean.getNextNodes().add( "7" );
		flowBean.getNextNodes().add( "9" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "7", "分管副总审核", "分管副总审核", "0" );
		flowBean.getNextNodes().add( "8" );
		flowBean.getNextNodes().add( "9" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "8", "总经理", "总经理", "0" );
		flowBean.getNextNodes().add( "9" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "9", "财务总监审核", "财务总监审核", "0" );
		flowBean.getNextNodes().add( "10" );
		flowBean.getNextNodes().add( "11" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "10", "北分商务", "北分商务", "0" );
		flowBean.getNextNodes().add( "11" );
		flowBeans.add( flowBean );

		flowBean = new FlowBean( "11", "出纳支付", "出纳支付", "0" );
		flowBeans.add( flowBean );

		json.put( "flows", flowBeans );
		json.put( "flowConnections", this.buildConnections( flowBeans ) );

		Struts2Utils.renderJson( json );
		return null;
	}

	/**
	 * 构建连接关系(可放给JS处理，也可代码处理).
	 * 
	 * @param flowBeans
	 * @return
	 */
	private Map<String, FlowConnectionBean> buildConnections( List<FlowBean> flowBeans ) {
		Map<String, FlowConnectionBean> flowConnectionBeans = Maps.newHashMap();
		FlowConnectionBean flowConnectionBean = null;
		for ( FlowBean bean : flowBeans ) {
			for ( String id : bean.getNextNodes() ) {
				String key = bean.getId() + '|' + id;
				// 通过
				if ( "1".equals( flowBeans.get( Integer.valueOf( id ) - 1 ).getState() )
						|| "2".equals( flowBeans.get( Integer.valueOf( id ) - 1 ).getState() ) ) {
					flowConnectionBean = new FlowConnectionBean();
					flowConnectionBean.setId( key );
					flowConnectionBean.setSourceId( bean.getId() );
					flowConnectionBean.setTargetId( id );
					flowConnectionBean.setMark( true );
				} else {
					flowConnectionBean = new FlowConnectionBean();
					flowConnectionBean.setId( key );
					flowConnectionBean.setSourceId( bean.getId() );
					flowConnectionBean.setTargetId( id );
					flowConnectionBean.setMark( false );
				}
				flowConnectionBeans.put( key, flowConnectionBean );
			}
		}
		return flowConnectionBeans;
	}

}
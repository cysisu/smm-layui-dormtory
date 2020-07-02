<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
  <link href="../css/helloWorld.css" rel="stylesheet" type="text/css"/>
</head>
<body>

  <div class="layui-form-item" >
    <div class="layui-inline" style="margin-top:20px">
      <label class="layui-form-label">身份证号</label>
      <div class="layui-input-inline">
        <input type="text" id="identityIdSearch" lay-verify="identity" name="identityIdSearch"  autocomplete="off" class="layui-input" style="width:200px">
      </div>
    </div>
    <div class="layui-inline" style="margin-top:20px">
      <label class="layui-form-label">房间号</label>
      <div class="layui-input-inline">
        <input type="text" id="roomNumberSearch"  name="roomNumberSearch"  autocomplete="off" class="layui-input" style="width:140px">
      </div>
    </div>

    <div class="layui-inline" style="margin-top:20px">
          <button class="layui-btn" id="find-user-btn">搜索</button>
          <button class="layui-btn" id="add-order-btn">增加</button>
     </div>
  </div>

    <!-- 添加订单弹出层 -->
    <div id="add-order-layer" style="display: none; padding: 20px">
      <form id="add-user-form" class="layui-form layui-form-pane" >
        <div class="layui-form-item">
          <label class="layui-form-label">身份证号</label>
          <div class="layui-input-block">
            <input type="text" name="identityId" lay-verify="required|identity" class="layui-input" >
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">房间</label>
          <div class="layui-input-block">
            <input type="text" name="roomNumber" class="layui-input" lay-verify="required" autocomplete="off">
          </div>
        </div>
        <div class="layui-form-item">
                  <label class="layui-form-label">工号</label>
                  <div class="layui-input-block">
                    <input type="text" name="workId" class="layui-input" lay-verify="required" autocomplete="off">
                   </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">状态</label>
          <div class="layui-input-inline">
                 <select name="status" id="status" lay-verify="required" lay-search="" style="height:39px;width:100px">
                          <option value="">选择</option>
                          <option value="1">booked</option>
                          <option value="2">check in</option>
                 </select>
           </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">预定日期</label>
          <div class="layui-input-block">
            <input type="text" name="predictTime" id="predictTime" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">       </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">天数</label>
          <div class="layui-input-block">
            <input type="text" name="days" class="layui-input" lay-verify="required" autocomplete="off">
          </div>
        </div>
        <div class="layui-form-item">
                  <label class="layui-form-label">备注</label>
                  <div class="layui-input-block">
                    <input type="text" name="label" class="layui-input"  autocomplete="off">
                  </div>
         </div>
        <div class="layui-form-item">
          <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="add-user-form-submit">提交</button>
            <button type="reset" class="layui-btn layui-btn-primary" style="margin-left:70px">重置</button>
          </div>
        </div>
      </form>
    </div>

<!-- 更新用户弹出层 -->
  <div id="update-user-layer" style="display: none; padding: 20px">
    <form id="update-user-form" class="layui-form layui-form-pane" lay-filter="update-user-form">

     <div class="layui-form-item" style="display: none;">
        <label class="layui-form-label">订单号</label>
        <div class="layui-input-block">
          <input type="text" name="orderIdUpdate" class="layui-input" readonly>
        </div>
     </div>

     <div class="layui-form-item">
              <label class="layui-form-label">状态</label>
              <div class="layui-input-inline">
                     <select name="statusUpdate"  lay-verify="required" lay-search="" style="height:39px;width:100px">
                              <option value="">选择</option>
                              <option value="1">booked</option>
                              <option value="2">check in</option>
                              <option value="3">leave</option>
                     </select>
               </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">房间号</label>
        <div class="layui-input-block">
          <input type="text" name="roomNumberUpdate" class="layui-input" lay-verify="required">
        </div>
      </div>

      <div class="layui-form-item">
                        <label class="layui-form-label">备注</label>
                        <div class="layui-input-block">
                          <input type="text" name="labelUpdate" class="layui-input"  autocomplete="off">
                        </div>
      </div>

      <div class="layui-form-item">
        <div class="layui-input-block">
          <button class="layui-btn" lay-submit lay-filter="update-user-form-submit">提交</button>
          <button type="reset" class="layui-btn layui-btn-primary" style="margin-left:70px">重置</button>
        </div>
      </div>
    </form>
  </div>


<table class="layui-hide" id="test" lay-filter="test"></table>



<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="../layui/layui.js" charset="utf-8"></script>

<script>
layui.use(['jquery', 'table', 'layer', 'form'], function(){
  var table = layui.table;
  var $ = layui.$;
  var table = layui.table;
  var layer = layui.layer;
  var form = layui.form;



  table.render({
    elem: '#test'
    ,url:'/order/getOrders'
    ,title: '用户数据表'
    ,cols: [[
      {field:'orderId', title:'订单号', width:90, fixed: 'center', align:'center',sort: true}
      ,{field:'roomNumber', title:'房间号', width:90, align:'center',sort: true}
      ,{field:'identityId', title:'身份证号', width:180, align:'center'}
      ,{field:'workId', title:'工号', width:80, align:'center'}
      ,{field:'status', title:'状态', width:80, align:'center'}
      ,{field:'inTime', title:'到达', align:'center',width:190, sort: true,templet: function(d)
            {if(d.inTime) return  layui.util.toDateString(d.inTime, 'yyyy-MM-dd HH:mm:ss');else return "";}}
      ,{field:'predictTime', title:'预计', align:'center',width:190, sort: true,templet: function(d)
            {if(d.predictTime) return  layui.util.toDateString(d.predictTime, 'yyyy-MM-dd HH:mm:ss');else return "";}}
      ,{field:'days', title:'天数',align:'center',width:80}
      ,{field:'price', title:'总价', align:'center',width:80,
            templet:function(d){return d.price*d.days}}
       ,{field:'outTime', title:'离开',align:'center',width:190, sort: true,templet: function(d)
            {if(d.outTime) return  layui.util.toDateString(d.outTime, 'yyyy-MM-dd HH:mm:ss');else return "";}}
      ,{field:'label', title:'标签',align:'center',width:80}
      ,{fixed: 'right', title:'备注', toolbar: '#barDemo', align:'center',width:120}
    ]]
    ,page: true
     // 表格容器id，用于表格重载
    ,id: 'user-tbl',
  });

    // 显示添加用户弹出层

    $('#add-order-btn').click(function() {
        // 每次显示前重置表单
        $('#add-user-form')[0].reset();
        layer.open({
         type: 1,
         title: '添加订单',
         skin: 'layui-layer-molv',
         area: ['700px'],
         content: $('#add-order-layer')
        });
    });


   $('#find-user-btn').click(function() {
       var identityIdSearch=$('#identityIdSearch').val();
       var roomNumberSearch=$('#roomNumberSearch').val();

       console.log(identityIdSearch+"  "+roomNumberSearch)
       table.reload('user-tbl', {
       page: {
              curr: 1 //重新从第 1 页开始
       }
       ,where:{identityId:identityIdSearch,roomNumber:roomNumberSearch}
       , url: '/order/findSpecificOrder'   //后台做模糊搜索接口路径
       , method: 'post'
      });
   });
     // 添加用户表单提交
    form.on('submit(add-user-form-submit)', function(data) {
         // ajax方式添加用户
         console.log(data);
         $.ajax({
         url: "/order/setOrder",
         type: "POST",
         data: JSON.stringify(data.field),
         contentType: 'application/json',
         dataType: 'json',
         success: function(data) {
         if (data.status == 1) {
              layer.close(layer.index);
              layer.msg('添加成功');
              table.reload('user-tbl');
         } else {
              layer.msg('添加失败');
         }
         },
         error: function() {
              console.log("ajax error");
         }
         });
         // 阻止表单跳转
         return false;
  });



  //监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    console.log(data);
    //console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
        $.ajax({
        url: '/order/' + data.orderId,
        type: "DELETE",
        dataType: 'json',
        success: function(data) {
             if (data.status == 1) {
                  layer.msg('删除成功');
                  table.reload('user-tbl');
              } else {
                    layer.msg('删除失败');
              }
        },
        error: function() {
               console.log("ajax error");
            }
        });
      });
    } else if(obj.event === 'edit'){
      console.log(data)
      form.val('update-user-form', {
             "orderIdUpdate": data.orderId,
             "roomNumberUpdate": data.roomNumber,
             "statusUpdate": data.status,
             "labelUpdate": data.label,
      });
      layer.open({
             type: 1,
             title: '更新订单',
             skin: 'layui-layer-molv',
             area: ['600px'],
             content: $('#update-user-layer')
      });
       form.on('submit(update-user-form-submit)', function(data) {
           console.log(data);
                  // ajax方式更新用户
           $.ajax({
           url: "/order/updateOrder",
           type: "POST",
           data: data.field,
           dataType: 'json',
           success: function(data) {
                if (data.status == 1) {
                    layer.close(layer.index);
                    layer.msg('更新成功');
                    table.reload('user-tbl');
                } else {
                    layer.msg('更新失败');
                }
           },
           error: function() {
                console.log("ajax error");
           }
           });
            // 阻止表单跳转
           return false;
        });
    }
  });



});
</script>


</body>
</html>
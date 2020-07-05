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

<button id="find-customer-btn" class="layui-btn" style="margin-left:25px;margin-top:20px;width:100px">搜索</button>
<div id="add-order-layer" style="padding: 20px">
  <form id="add-customer-form" class="layui-form layui-form-pane" >
 <div class="layui-form-item" >
    <div class="layui-inline" style="margin-top:10px">
      <label class="layui-form-label">房间号</label>
      <div class="layui-input-inline">
        <input type="text"  id="roomNumber" name="roomNumber"  lay-verify="required" autocomplete="off" class="layui-input" style="width:200px">
      </div>
    </div>
    <div class="layui-inline" style="margin-top:10px">
      <label class="layui-form-label">价格</label>
      <div class="layui-input-inline">
        <input type="text" id="price"  name="price"  autocomplete="off" class="layui-input" style="width:140px">
      </div>
    </div>

    <div class="layui-inline" style="margin-top:10px">
          <label class="layui-form-label">房间类型</label>
                   <div class="layui-input-inline">
                          <select name="type" id="type" lay-verify="required" lay-search="" style="height:39px;width:100px;margin-left:20px">
                                   <option value="">选择</option>
                                   <option value="1">大床房</option>
                                   <option value="2">单人间</option>
                                   <option value="3">总统套房</option>
                          </select>
                    </div>
     </div>

       <div class="layui-inline"  style="margin-top:10px" >
                   <label class="layui-form-label">状态</label>
                   <div class="layui-input-inline">
                          <select name="status" id="status" lay-verify="required" lay-search="" style="height:39px;width:100px;margin-left:20px">
                                   <option value="">选择</option>
                                   <option value="1">booked</option>
                                   <option value="2">rented</option>
                                   <option value="3">Vacant</option>
                          </select>
                   </div>
        </div>
    <div class="layui-form-item">
         <div class="layui-inline" style="margin-top:10px">
              <button class="layui-btn" lay-submit lay-filter="add-customer-form-submit"  style="margin-left:400px">添加</button>
              <button type="reset" class="layui-btn" style="margin-left:300px">重置</button>
         </div>
    </div>
  </div>
</form>
</div>



<table class="layui-hide" id="test" lay-filter="test"></table>



<script type="text/html" id="barDemo">
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
    ,url:'/roomInfo/getRoomInfos'
    ,title: '用户数据表'
    ,cols: [[
      {field:'roomNumber', title:'房间号', width:350, fixed: 'center', align:'center',sort: true}
      ,{field:'type', title:'房间类型', width:300, align:'center',sort: true}
      ,{field:'price', title:'当前价格', width:300, align:'center'}
      ,{field:'status', title:'当前状态', width:350, align:'center'}
      ,{fixed: 'right', title:'备注', toolbar: '#barDemo', align:'center',width:120}
    ]]
    ,page: true
     // 表格容器id，用于表格重载
    ,id: 'user-tbl',
   });
   $('#find-customer-btn').click(function() {
       var status=$('#status').val();
       var roomNumber=$('#roomNumber').val();
       var price=$('#price').val();
       var type=$('#type').val();
       console.log("sex:"+sex);

       table.reload('user-tbl', {
       page: {
              curr: 1 //重新从第 1 页开始
       }
       ,where:{identityId:identityId,sex:sex,name:name,phone:phone}
       , url: '/roomInfo/findSpecificRoomInfo'   //后台做模糊搜索接口路径
       , method: 'post'
      });
  });

      // 添加客户表单提交
      form.on('submit(add-customer-form-submit)', function(data) {
           // ajax方式添加用户
           console.log(data);
           $.ajax({
           url: "/roomInfo/insert",
           type: "POST",
           data: JSON.stringify(data.field),
           contentType: 'application/json',
           dataType: 'json',
           success: function(data) {
           if (data.status == 1) {
                layer.close(layer.index);
                layer.msg('添加成功');
                table.reload('user-tbl');
           } else if(data.status==-1) {
                layer.msg('该用户已经存在');
           }else{
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
            url: '/roomInfo/' + data.roomNumber,
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
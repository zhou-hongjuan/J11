 
	
	$(".open > a").focus(function () {
	$(this).css({'background-color':'none'});
})
/*
//自定义数据
// var products=[
// 	{img:"images/sp07.jpg",commodity:"蓝山咖啡",no:"Model No: 8768",price:"100.00",}
// ]

	*/
	
	
	
	var fina_temp=0;//最后的总计
	var temp=0;//商品总计
	var  row_total=0//每行商品总价格
$(function(){
	var username=$(".username").html("张三");//用户昵称
	
	var sex=1;//判断用户性别
	if(sex==1){
		$(".sex").html("先生");
	}else{
		$(".sex").html("女士");
	}
	var garden=2  //用户等级
	$(".garden").html("<img src='images/vip"+garden+".png' />")//显示用户等级图片
	
		function vip(){//为会员单独建立一个方法 后续使用
		var discount=$("#discount");//获取折扣节点
			if(garden==1){
				discount.html("0.98");
			}else if(garden==2){
				discount.html("0.95");
			}else if(garden==3){
				discount.html("0.95");
			}else if(garden==4){
				discount.html("0.85");
			}else if(garden==5){
				discount.html("0.80");
			}
	}
	
	
	// 运费方法
	function freight(){
		var yf=$(".freight")//运费的节点
		var add=1   //地址名
			if(add=1){
				yf.html("10.00")//省内10
			}	else{
				yf.html("20.00")//省外20
			}
			
	}
	
	
	//初始化状态
	//当购物车内有东西的时候就开启遍历
	var shop=$(".cart-item-info").length;
	var carts=$(".cart-items").find(".cart-header").length;
	// alert(carts)d
	if(carts>0){
		    
			var price_rowoo=$(".cart-item-info");
			for(var i=0;i<price_rowoo.length;i++){
			var in_price = $(".cart-item-info:eq("+i+")").find('.price').html();//获得初始的单价
			var in_input=$(".cart-item-info:eq("+i+")").find(".input").val();//获取初始袋数
			var in_rowtotal=parseInt(in_price )* parseInt(in_input )//每行总价
			temp =temp+in_rowtotal;//获得初始总价
			$(".a_total").html(temp);
			
			
			vip();//调用vip方法
			freight();//调用运费方法
		// alert(count)	
			function  finally_money() {  //算finallymoney结尾公用方法
				var freight_moeny =$(".freight").html();//获得运费
			var fre_comm=parseInt(freight_moeny)+temp;//运费+商品的价格
			var discount=parseFloat($("#discount").html());//获得折扣
						fina_temp=fre_comm * discount
			$(".final").html(fina_temp)
			$(".simpleCart_total").html("￥"+fina_temp)
			
			}
			finally_money();//总结算
			
			





			}
			
	}else {//购物车没东西
	
		$(".a_total").html("00.00");//商品  00.00
		$("#discount").html("---");//折扣  ---
		$(".freight").html("---");//运费  ---
		$(".simpleCart_total").html("空的购物车")//右上角 空的购物车
		$(".final").html("00.00")
		
	}
		
		
	$(".add").click(function(){      //增减按钮
		var num = $(this).prev().val();
		num++;  //累计
		parseInt(num);  //转换
		$(this).prev().val(num);  //赋值
			var count=parseInt(num);//获取袋数
	var price_all=parseInt($(this).parent().parent().children("h4").children(".price").html());//获取单价


		
	
	temp= temp+price_all;//获取实际总价
	$('.a_total').html(temp)//赋值给商品显示总价
		vip();//调用vip方法
		freight();//调用运费方法

			
	finally_money();//总结算方法
	
	})
	
	
	
	$(".sub").click(function(){
		
		var price_all=parseInt($(this).parent().parent().find(".price").html());//获取单价
		var num = $(this).next().val();//获取input框
		if(num==2){
			temp=temp-price_all;
			// alert("不能再少了")
		}
		
		num--;
		if(num<=1){
			num=1;
		}
		parseInt(num);
		$(this).next().val(num);
		var count=parseInt(num);//获取袋数;
		
	
		if(num!=1){
			temp=temp-price_all;//当点击减号计算总价
		}
		$(".a_total").html(temp)
		
		finally_money();
		
	})
	
	
	//删除
	$(".close").on('click',function () {//删除方法 
			var price_all=parseInt($(this).parent().find(".price").html());//获得单价
			var count=parseInt($(this).parent().find(".input").val())//获得袋数
			var row_price=price_all * count//单行商品总价
			
			temp=parseInt($(".a_total").html())-row_price;//一个新的价格
			var a_total=$(".a_total").html(temp);//获得商品总价并填充值
			
			finally_money();
			$(this).parents('.cart-header').remove();
			
			if(temp==0){
				$(".a_total").html("00.00");//商品  00.00
			$("#discount").html("---");//折扣  ---
			$(".freight").html("---");//运费  ---
			$(".simpleCart_total").html("空的购物车")//右上角 空的购物车
			$(".final").html("00.00")	
		}
	})	
		
$(".order").on("click",function () {

				 
				 
				 
		layer.msg('确认下单吗？', {
  time: 0 //不自动关闭
  ,btn: ['确认', '再想想']
  ,yes: function(index){//当点击确认调用
    layer.close(index);
   	layer.open({
     type: 1,
     skin: 'layui-layer-demo', //样式类名
     closeBtn: 1, //不显示关闭按钮
     anim: 2,
     shadeClose: true, //开启遮罩关闭
     content: '内容'
   });			 
  }
});		 
				 
				 
})
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
})
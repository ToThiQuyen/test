
$(document).ready(function () {
	
 
    SubTotal();
	function SubTotal(isEventChange){
		var subTotal = 0; 
		
		
		$(".totalPrice").each(function(){
			var price = $(this).text();
			//alert(price)
			//price.slice(0);
			
			subTotal = subTotal + parseFloat(price);
			
			if(!isEventChange){
				$(this).html(price);
			}
			//alert("sub"+subTotal);
			
			$("#subtotal").html(subTotal+" $");
			$("#delivery").html((subTotal*0.05));
			$("#total").html(subTotal + (subTotal*0.05)+" $")
			
			
	});
			
	};
	
	
	
	$(".qty-text").change(function(){
	var quantity = $(this).val();
	
	let price = $(this).closest("tr").find(".price").attr("data-value");
	
	var totalPrice = quantity * parseInt(price);

	$(this).closest("tr").find(".totalPrice").html(totalPrice);
	SubTotal(true);
		    //update cart items quantity
    $('.qty-text').blur(function() {
        var newQuantity = $(this).val();
        var key = $(this).attr("data-value");
    		$.ajax({
                url : 'add-to-cart?action=updateQuantity',
                type: "POST",
                cache: false,
    		    data :{
                    key : key,
                    newQuantity : newQuantity ,
    		    }
    		}).done(function (value) {
    			
           });    
    });

});

  
	
  
});



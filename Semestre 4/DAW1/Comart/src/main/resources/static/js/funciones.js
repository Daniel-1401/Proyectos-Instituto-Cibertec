function eliminar(id){
		swal({
		  title: "Esta seguro de Eliminar?",
		  text: "Once deleted, you will not be able to recover this imaginary file!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((ok) => {
		  if (ok) {
				$.ajax({
					url:"/eliminarProducto/"+id,
					success: function(res){
						console.log(res);
					}
				});
		    swal("Poof! Your imaginary file has been deleted!", {
		      icon: "success",
		    }).then((ok)=>{
					if(ok){
						location.href="/listarProductos";
					}
				});
		  } else {
		    swal("Your imaginary file is safe!");
		  }
		});
	}
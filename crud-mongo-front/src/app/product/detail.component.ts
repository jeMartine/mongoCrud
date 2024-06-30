import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router} from '@angular/router';
import { Product } from '../model/product';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrl: './detail.component.css'
})
export class DetailComponent implements OnInit{

  product: Product | undefined; 
  constructor(
    private productService: ProductService,
    private toast: ToastrService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ){}

  ngOnInit(): void {
    this.getProduct()
  }

  getProduct(): void{
    const id= this.activatedRoute.snapshot.params['id'];
    this.productService.detail(id).subscribe(
      data =>{
        this.product = data;
      },
      err =>{
        this.toast.error(err.error.message, 'Error', {
          timeOut: 3000, 
          positionClass: 'toast-top-center',
          closeButton: true, // Asegúrate de que el botón de cerrar esté disponible
          progressBar: true // Muestra una barra de progreso en la alerta
        });
        this.router.navigate([''])
      }
    );
  }
}

import { Component, OnInit } from '@angular/core';
import { Product } from '../model/product';
import { ProductService } from '../services/product.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent implements OnInit {

  products: Product[] = []

  constructor(
    private productService: ProductService,
    private toast: ToastrService 
  ){}

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(): void {
    this.productService.list().subscribe(
      data => {
        this.products = data;
      },
      err =>{
        this.toast.error(err.error.message, 'Error', {timeOut: 3000, positionClass: 'toast-top-center'});
      }
    );
  }

}

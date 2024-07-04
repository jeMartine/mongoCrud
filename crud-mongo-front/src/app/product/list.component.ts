import { Component, OnInit } from '@angular/core';
import { Product } from '../model/product';
import { ProductService } from '../services/product.service';
import { ToastrService } from 'ngx-toastr';
import Swal from 'sweetalert2';
import { StorageService } from '../services/storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent implements OnInit {

  products: Product[] = []

  constructor(
    private productService: ProductService,
    private toast: ToastrService,
    private storageService: StorageService,
    private router: Router,

  ) { }

  ngOnInit(): void {
    this.getProducts();
  }

  getProducts(): void {
    this.productService.list().subscribe(
      data => {
        this.products = data;
      },
      err => {
        this.toast.error(err.error.message, 'Error', { timeOut: 3000, positionClass: 'toast-top-center' });
      }
    );
  }

  onDelete(id: number): void {
    Swal.fire({
      title: 'Are you sure?',
      text: 'This cannot undo',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Ok',
      cancelButtonText: 'Cancel'
    }).then((result) => {
      if (result.value) {
        this.productService.delete(id).subscribe(
          data => {
            Swal.fire(
              'Success',
              data.message,
              'success'
            )
            this.getProducts();
          },
          err => {
            this.toast.error(err.error.message, 'Error', {
              timeOut: 3000,
              positionClass: 'toast-top-center',
            });
          }
        );

        console.log('deleted product' + id);
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire(
          'canceled',
          'Product not deleted',
          'error'
        )
      }
    })
  }

  setProduct(product: Product): void {
    this.storageService.setProduct(product);
    this.router.navigate(['/update']);
  }

}

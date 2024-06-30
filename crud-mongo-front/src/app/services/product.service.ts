import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  
  productURL = environment.apiResrURL + '/product';

  constructor(private httpClient: HttpClient) { }

  //forma para recibir la lista de productos
  public list(): Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.productURL);
  }

  public detail(id: number): Observable<Product>{
    return this.httpClient.get<Product>(this.productURL + `/${id}`);
  }
}

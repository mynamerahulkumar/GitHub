import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list-grid.component.html',
  //  templateUrl: './product-list-table.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
  products:Product[]=[];
  categoryId:number=1;
  constructor(private productService:ProductService,private route:ActivatedRoute){

  }
  ngOnInit(){
    this.route.paramMap.subscribe(()=>{
      this.listProducts();
    });
  }
  listProducts() {
    const hasCategory:boolean=this.route.snapshot.paramMap.has('id');
    //async
    if(hasCategory){
      this.categoryId=+this.route.snapshot.paramMap.get('id')!;
    }
    this.productService.getProductList(this.categoryId).subscribe(
      data=>{
        this.products=data;
      }
    )
  }

}

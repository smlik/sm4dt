import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {EmployeeService} from "../employee.service";
import {take} from "rxjs/operators";
import {IEmployee} from "../employee";
import {MatDialog} from "@angular/material/dialog";
import {AddEmployeeComponent} from "../add-employee/add-employee.component";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'email', 'phoneNumber', 'hireDate', 'salary'];
  employeeData: MatTableDataSource<IEmployee> = new MatTableDataSource();
  pageSize = 5;
  currentPage = 0;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(public employeeService: EmployeeService, private dialog: MatDialog) {
  }

  ngOnInit() {
    this.getEmployeesList();
  }

  ngAfterViewInit() {
    this.employeeData.paginator = this.paginator;
  }

  getEmployeesList(): void {
    this.employeeService.getEmployees(this.currentPage, this.pageSize).pipe(take(1)).subscribe(res => {
      this.employeeData.data = res.content;
      setTimeout(() => {
        this.paginator.pageIndex = this.currentPage;
        this.paginator.length = res.totalRecords;
      });
    });
  }

  pageChanged(event: PageEvent) {
    this.pageSize = event.pageSize;
    this.currentPage = event.pageIndex;
    this.getEmployeesList();
  }

  addEmployee(): void {
    let dialog = this.dialog.open(AddEmployeeComponent, {
      width: '30vw'
    });
    dialog.afterClosed().pipe(take(1)).subscribe(res => {
      if (res) {
        this.getEmployeesList();
      }
    },error => console.log(error))
  }
}

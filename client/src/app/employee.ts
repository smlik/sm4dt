export interface IEmployee {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  phoneNumber: string;
  hireDate: string;
  salary: number;
}

export interface IApiResponse {
  total: number;
  totalRecords: number;
  content: IEmployee[];
}

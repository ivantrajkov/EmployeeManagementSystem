<h1>Employee management system project</h1>

<h2>Problem description</h2>
<p>
This project is an implementation of a CRUD-operations back-end and React front-end to showcase a simple system for managing employees
</p>
<br>

<h2>Showcase:</h2>
<p><b>The interface of the app</b></p>
<img src="pictures/Screenshot_3.png" alt="No Image alt">
<p><b>Adding a new Employee</b></p>
<img src="pictures/Screenshot_2.png" alt="No Image alt">
<br>
<h2>Some details of the code</h2>
<p><b>Axios for sending simplified API requests</b></p>

```javascript
import axios from "axios"

const REST_API_BASE_URL = "http://localhost:8080/api/employees";

export const listEmployees = () => {
    return axios.get(REST_API_BASE_URL)
}

export const createEmployee = (employee) => axios.post(REST_API_BASE_URL, employee)
export const getEmployee = (employeeId) => axios.get(REST_API_BASE_URL + '/' + employeeId)
export const updateEmployee = (employeeId, employee) => axios.put(REST_API_BASE_URL + '/' + employeeId, employee)
export const deleteEmployee = (employeeId) => axios.delete(REST_API_BASE_URL + '/' + employeeId)
```

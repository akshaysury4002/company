
function setupTable() {
    const table = document.getElementById('tableDept')

    apiFetchAllBookings(table)
}

setupTable()

function propulateActualData(table, depts) {

    for(const dept of depts) {

       

        const { deptId, deptName} = dept

        const checkForRoles = `./role.html?deptId=${deptId}`

        const creatRole = `./createRole.html?deptId=${deptId}`
        


        const row = table.insertRow()
        row.insertCell(0).innerHTML = deptId
        row.insertCell(1).innerHTML = deptName
        row.insertCell(2).innerHTML = `
        <button type="button" class="btn btn-secondary" onclick="window.location='${checkForRoles}';" data-bs-dismiss="modal">View available roles</a></button>
        <button type="button" class="btn btn-secondary" onclick="window.location='${creatRole}';" data-bs-dismiss="modal">create roles for dept</a></button>
        
        `
    }
}



function apiFetchAllBookings(table) {

    
    axios.get('http://localhost:8080/company/getdept')
        .then(res => {
            const { data } = res
            console.log(data)  
            const { sts, msg, bd } = data

            propulateActualData(table, bd)
        })
        .catch(err => console.log(err))
    
        
}
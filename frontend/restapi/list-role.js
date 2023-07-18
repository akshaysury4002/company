
const readIdQueryParam = () => {
    const params = new Proxy(new URLSearchParams(window.location.search), {
        get: (searchParams, prop) => searchParams.get(prop),
    });
    return params.deptId
}


console.log(readIdQueryParam())

function setupTable() {
    const table = document.getElementById('tableBooking')

    apiFetchAllBookings(table)
}

setupTable()

function propulateActualData(table, roles) {

    for(const role of roles) {

       

        const { roleId, roleName, experience, location} = role

        const showApplicationURL = `./viewapplication.html?roleId=${roleId}`
        const ApplyUrl = `./application.html?roleId=${roleId}`


        const row = table.insertRow()
        row.insertCell(0).innerHTML = roleId
        row.insertCell(1).innerHTML = roleName
        row.insertCell(2).innerHTML = experience
        row.insertCell(3).innerHTML = location
        row.insertCell(4).innerHTML = `
        <button type="button" class="btn btn-secondary" onclick="window.location='${showApplicationURL}';" data-bs-dismiss="modal">View Applocations for role</a></button>
        <button type="button" class="btn btn-secondary" onclick="window.location='${ApplyUrl}';" data-bs-dismiss="modal">Apply For Role</a></button>
        
        `
    }
}



function apiFetchAllBookings(table) {

    
    const deptId=readIdQueryParam()

    axios.get(`http://localhost:8080/company/getrole/${deptId}`)
        .then(res => {
            const { data } = res
            console.log(data)  
            const { sts, msg, bd } = data

            propulateActualData(table, bd)
        })
        .catch(err => console.log(err))
    
        
}


import styles from './Dashboard.module.scss'


function Dashboard() {

    return (
        <div className={styles.board}>

            <a className={styles.employees}
               href="http://localhost:3000/employee">count employee</a>

            <a className={styles.newemployee}
               href="http://localhost:3000/employee">add employee</a>


            <a className={styles.requests}
               href="http://localhost:3000/contactus">count requests</a>

            <a className={styles.newerequests}
               href="http://localhost:3000/employee">add request</a>

            <a className={styles.documentation}
               href="http://localhost:3000/documentation">documentation</a>

        </div>
    )
}

export default Dashboard;
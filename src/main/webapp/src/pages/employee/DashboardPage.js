import styles from './Dashboard.module.scss'
import {Link} from "react-router-dom";


function Dashboard() {

    return (
        <div className={styles.board}>

            <Link className={styles.employees}
                  to={'/employees'}>count employees</Link>

            <Link className={styles.newemployee}
                  to={'/employee'}>add employee</Link>

            <Link className={styles.requests}
                  to={'/contactus'}>count requests</Link>

            <Link className={styles.newerequests}
                  to={'/contactus'}>add request</Link>

            <Link className={styles.documentation}
                  to={'/documentation'}>documentation</Link>


        </div>
    )
}

export default Dashboard;
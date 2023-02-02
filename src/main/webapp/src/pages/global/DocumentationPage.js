import styles from './DocumentationPage.module.scss'

export const DocumentationPage = () => {
    return (
        <div>
            <div className={styles.contents}>
                <h1>Documentation</h1>
                <ul>
                    <li><a href=''>Project Structure</a></li>
                    <li><a href=''>Page structure & CSS</a></li>
                    <li><a href=''>Components</a></li>
                    <li><a href=''>Demo tutorial</a></li>
                </ul>
            </div>
            <div className={styles.separator}>1</div>
            <div className={styles.separator}>2</div>
            <div className={styles.separator}>3</div>
            {/*<div className={styles.blackbg} id={'components'}>*/}
            {/*    <Buttons/>*/}
            {/*    <Inputs/>*/}
            {/*</div>*/}
        </div>
    )
}
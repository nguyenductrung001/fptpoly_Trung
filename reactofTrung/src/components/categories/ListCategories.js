import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Button from '@material-ui/core/Button';
import Switch from '@material-ui/core/Switch';
function ListCategories({ listPhon, onClickRow, btnDeleteOnClick }) {

    return (
        <Table>
            {/* <thead></thead> */}
            <TableHead>
                {/* <tr></tr> */}
                <TableRow>
                    <TableCell>ID</TableCell>
                    <TableCell>Name</TableCell>
                </TableRow>
            </TableHead>
            <TableBody>
                {
                    listPhon.map(function (value, index) {
                        return (
                            <TableRow
                                onClick={(event) => {
                                    onClickRow(event, value, index);
                                }}
                                key={index}>
                                <TableCell className="Id">{value.id}</TableCell>
                                <TableCell className="name">{value.name}</TableCell>
                                <TableCell className="mot">
                                    <Switch

                                        name="checkedB"
                                        color="primary"
                                        inputProps={{
                                            'aria-label': 'primary checkbox'
                                        }} />
                                </TableCell>
                                <TableCell className="Secondary">
                                    <Button
                                        onClick={
                                            (event) => {
                                                btnDeleteOnClick(event, value, index)
                                            }
                                        }
                                        color="secondary"
                                        BackGroundColor="yellow"
                                    >

                                        Delete
                                </Button>
                                </TableCell>
                                <TableCell className="Secondary">
                                    <Button color="secondary">
                                        Update
                                </Button>
                                </TableCell>
                            </TableRow>
                        )
                    })
                }
            </TableBody>
        </Table>
    )


}
export default ListCategories
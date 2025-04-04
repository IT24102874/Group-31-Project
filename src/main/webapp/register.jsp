<form action="register" method="post">
    Role:
    <select name="role">
        <option value="Patient">Patient</option>
        <option value="Doctor">Doctor</option>
    </select>

    Specialization (Doctors Only): <input type="text" name="specialization">
    Name: <input type="text" name="name">
    Email: <input type="email" name="email">
    Phone: <input type="text" name="phone">
    Username: <input type="text" name="username">
    Password: <input type="password" name="password">
    <input type="submit" value="Register">
</form>
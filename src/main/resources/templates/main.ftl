<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <form action="/resolve/teacherByDayAndLocation" class="border border-primary rounded p-4 my-4">
        <span>Select day and location to get info about teacher who worked in this day in this location:</span>
        <p>
            Day:
            <select name="day" id="">
                <option value="Monday">Monday</option>
                <option value="Tuesday">Tuesday</option>
                <option value="Wednesday">Wednesday</option>
                <option value="Thursday">Thursday</option>
                <option value="Friday">Friday</option>
                <option value="Saturday">Saturday</option>
            </select>
        </p>
        <p>
            Location:
            <select name="location" id="">
                <option value="4-20">4-20</option>
                <option value="2-20">2-20</option>
            </select>
        </p>
        <button type="submit">Submit</button>
    </form>
    <form action="/resolve/teacherByNotDay" class="border border-primary rounded p-4 my-4">
        <span>Select day to get info about teacher who not worked in this day:</span>
        <p>
            Day:
            <select name="day" id="">
                <option value="Monday">Monday</option>
                <option value="Tuesday">Tuesday</option>
                <option value="Wednesday">Wednesday</option>
                <option value="Thursday">Thursday</option>
                <option value="Friday">Friday</option>
                <option value="Saturday">Saturday</option>
            </select>
        </p>
        <button type="submit">Submit</button>
    </form>
    <form action="/resolve/daysByNumberOfLectures" class="border border-primary rounded p-4 my-4">
        <span>Enter number to get list of days with that number of lectures:</span>
        <p>
            <label for="numberOfDays">Number:</label>
            <input id="numberOfDays" type="text" placeholder="Enter number of lectures" name="number">
        </p>
        <button type="submit">Submit</button>
    </form>
    <form action="/resolve/daysByNumberOfLocationsReserved" class="border border-primary rounded p-4 my-4">
        <span>Enter number to get list of days with that number or locations reserved:</span>
        <p>
            <label for="numberOfDays">Number:</label>
            <input id="numberOfDays" type="text" placeholder="Enter number of reserved locations" name="number">
        </p>
        <button type="submit">Submit</button>
    </form>
    <form action="/resolve/transferLectures" class="border border-primary rounded p-4 my-4">
        <span>Select day to transfer all lectures from this day to Saturday:</span>
        <p>
            Day:
            <select name="day" id="">
                <option value="Monday">Monday</option>
                <option value="Tuesday">Tuesday</option>
                <option value="Wednesday">Wednesday</option>
                <option value="Thursday">Thursday</option>
                <option value="Friday">Friday</option>
                <option value="Saturday">Saturday</option>
            </select>
        </p>
        <button type="submit">Submit</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>